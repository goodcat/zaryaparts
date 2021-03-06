package ru.zaryaparts.exist.parser;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ru.zaryaparts.exist.http.ExistSearch;
import ru.zaryaparts.exist.http.SearchResult;
import ru.zaryaparts.exist.http.SearchStatus;

public class ExistParser implements IParser {
	Logger LOG = Logger.getLogger(ExistParser.class);

	public ParseResult parse(String htmlContent) {
		ParseResult data = new ParseResult();
		if (htmlContent == null){
			LOG.warn("htmlContent for parsing is empty");
			return data;
		}
		Document doc = Jsoup.parse(htmlContent);
		Elements rows = doc.select("tr[id]");
		if (rows == null) {
			LOG.warn("Get empty table while trying parse Exist search result");
			data.setParsingStatus(ParseStatus.NOT_FOUND);
			return data;
		}
		boolean extColumn = isInfColumn(doc);
		ParsedRow prevRow = null;
		for (Element row : rows) {
			Elements columns = row.select("td");
			if (columns == null) {
				LOG.warn("Get empty columns while trying parse Exist search result");
				continue;
			}
			final int numberOfColumns = columns.size();
			ParsedRow dataRow = new ParsedRow();
			if (numberOfColumns >= 8) {
				dataRow.setFirmName(columns.get(0).text());
				dataRow.setArticul(columns.get(1).text());
				dataRow.setDescription(columns.get(2).text());
				dataRow.setInformation(columns.get(3).text());
				dataRow.setCount(columns.get(4).text());
				if(numberOfColumns >= 9) {
					if (extColumn) {
						dataRow.setPeriod(columns.get(5).text());
						dataRow.setPrice(columns.get(6).text());
					} else {
						dataRow.setPeriod(columns.get(6).text());
						dataRow.setPrice(columns.get(7).text());
					}
				}
				else {
					dataRow.setPeriod(columns.get(5).text());
					dataRow.setPrice(columns.get(6).text());
				}
				prevRow = dataRow;
			}
			if(numberOfColumns == 5) {
				if(prevRow != null){
					dataRow.setFirmName(prevRow.getFirmName());
					dataRow.setArticul(prevRow.getArticul());
					dataRow.setDescription(prevRow.getDescription());
					dataRow.setInformation(prevRow.getInformation());
					dataRow.setCount(columns.get(0).text());
					dataRow.setPeriod(columns.get(2).text());
					dataRow.setPrice(columns.get(3).text());
				}
			}
			if(numberOfColumns == 4) {
				if(prevRow != null){
					dataRow.setFirmName(prevRow.getFirmName());
					dataRow.setArticul(prevRow.getArticul());
					dataRow.setDescription(prevRow.getDescription());
					dataRow.setInformation(prevRow.getInformation());
					dataRow.setCount(columns.get(0).text());
					dataRow.setPeriod(columns.get(1).text());
					dataRow.setPrice(columns.get(2).text());
				}
			}
			data.getParsedRows().add(dataRow);
			data.setParsingStatus(ParseStatus.SUCCESS);
		}
		return data;
	}
	
	private boolean isInfColumn(Document doc) {
		Elements thList = doc.select("th[scope]");
		if(thList != null) {
			if(thList.size() >= 2) {
				Element lastTh = thList.get(thList.size() - 2);
				String text = lastTh.text();
				return "Инф".equals(text);
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		ExistSearch client = new ExistSearch();
		SearchResult searchResult = client.makeSearch("QSRP10");
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			return;
		}
		ExistParser parser = new ExistParser();
		ParseResult data = parser.parse(searchResult.getHtmlContent());
		System.out.println(data.getParsedRows());
	}
}