package ru.zaryaparts.exist.parser;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ru.zaryaparts.exist.http.ExistSearch;
import ru.zaryaparts.exist.http.SearchResult;
import ru.zaryaparts.exist.http.SearchStatus;

public class ExistCatalogParser {
	Logger LOG = Logger.getLogger(ExistCatalogParser.class);

	public ParseCatalogResult parse(String htmlContent) {
		LOG.info("Execute ExistCatalogParser.parse");
		ParseCatalogResult data = new ParseCatalogResult();
		if (htmlContent == null) {
			LOG.warn("htmlContent for parsing is empty");
			data.setParsingStatus(ParseStatus.NOT_FOUND);
			return data;
		}
		Document doc = Jsoup.parse(htmlContent);
		Elements searchResultTables = doc.select("table.tbl");
		if (searchResultTables == null) {
			LOG.warn("List of search result tables is null");
			data.setParsingStatus(ParseStatus.NOT_FOUND);
			return data;
		}
		if (searchResultTables.size() < 1) {
			LOG.warn("List of search result tables is empty");
			data.setParsingStatus(ParseStatus.NOT_FOUND);
			return data;
		}
		if (searchResultTables.size() > 1) {
			LOG.warn("Table of search result contains more then 1 element");
		}
		Element searchResultTable = searchResultTables.get(0);
		Elements rows = searchResultTable.select("tr");
		if (rows == null) {
			LOG.warn("Search result table rows is null");
			data.setParsingStatus(ParseStatus.NOT_FOUND);
			return data;
		}
		if (rows.size() < 1) {
			LOG.warn("Search result table rows is empty");
			data.setParsingStatus(ParseStatus.NOT_FOUND);
			return data;
		}
		for (Element row : rows) {
			Elements columns = row.select("td");
			if (columns == null) {
				LOG.warn("Columns in row of search result table is null");
				continue;
			}
			if (columns.size() < 3) {
				LOG.warn("Not enough columns in search result table");
				continue;
			}
			if (columns.size() > 3)
				LOG.warn("There is more then 3 columns in search result table");
			if (columns.size() >= 4) {
				Element firmNameColumn = columns.get(0);
				Element articulColumn = columns.get(1);
				Element descriptionColumn = columns.get(2);
				Element pidColumn = columns.get(3);

				Elements pidLinks = pidColumn.select("a");
				if (pidLinks == null || pidLinks.size() < 1) {
					LOG.warn("Links in column not found");
					continue;
				}
				Element pidLink = pidLinks.get(0);

				ParsedCatalogRow parsedRow = new ParsedCatalogRow();
				parsedRow.setFirmName(firmNameColumn.text());
				parsedRow.setArticul(articulColumn.text());
				parsedRow.setDescription(descriptionColumn.text());
				parsedRow.setPid(pidLink.attr("href"));

				data.getParsedRows().add(parsedRow);
			} else {
				Element firmNameColumn = columns.get(0);
				Element descriptionColumn = columns.get(1);
				Element pidColumn = columns.get(2);

				Elements pidLinks = pidColumn.select("a");
				if (pidLinks == null || pidLinks.size() < 1) {
					LOG.warn("Links in column not found");
					continue;
				}
				Element pidLink = pidLinks.get(0);

				ParsedCatalogRow parsedRow = new ParsedCatalogRow();
				parsedRow.setFirmName(firmNameColumn.text());
				parsedRow.setDescription(descriptionColumn.text());
				parsedRow.setPid(pidLink.attr("href"));

				data.getParsedRows().add(parsedRow);
			}

			data.setParsingStatus(ParseStatus.SUCCESS);
		}
		return data;
	}

	public static void main(String[] args) {
		ExistSearch client = new ExistSearch();
		SearchResult searchResult = client.makeSearch("11111");
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			return;
		}
		ExistCatalogParser parser = new ExistCatalogParser();
		ParseCatalogResult data = parser.parse(searchResult.getHtmlContent());
		System.out.println(data.getParsedRows());
	}
}
