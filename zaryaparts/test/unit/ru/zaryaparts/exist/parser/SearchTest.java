package ru.zaryaparts.exist.parser;

import org.junit.Test;

import ru.zaryaparts.exist.http.ExistSearch;
import ru.zaryaparts.exist.http.SearchResult;
import ru.zaryaparts.exist.http.SearchStatus;

public class SearchTest {
	@Test
	public void testLoadCatalogPageAndLoadPartsPage() {
		ExistSearch client = new ExistSearch();
		SearchResult searchResult = client.makeSearch("90915-10001");
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			return;
		}
		ExistCatalogParser parser = new ExistCatalogParser();
		ParseCatalogResult data = parser.parse(searchResult.getHtmlContent());
		System.out.println(data.getParsedRows());
		
		ParsedCatalogRow row = data.getParsedRows().get(0);
		String pid = row.getPid().substring(row.getPid().indexOf("=") + 1);
		System.out.println(pid);
		
		client = new ExistSearch();
		client.setParamName("pid");
		searchResult = client.makeSearch(pid);
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			return;
		}
		ExistParser existParser = new ExistParser();
		ParseResult existResult = existParser.parse(searchResult.getHtmlContent());
		System.out.println(existResult.getParsedRows());
	}
}