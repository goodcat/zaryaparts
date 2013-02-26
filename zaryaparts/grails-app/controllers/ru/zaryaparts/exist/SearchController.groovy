package ru.zaryaparts.exist

import ru.zaryaparts.exist.http.*;
import ru.zaryaparts.exist.parser.*;

class SearchController {

    def index() { 
    	print "Search: ${request.getParameter('partNumber')}"
    	
    	ExistSearch client = new ExistSearch();
		SearchResult searchResult = client.makeSearch(request.getParameter("partNumber"));
		print "searchResult ${searchResult}"
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			render(view: "not_found");
		}
		if(searchResult.getHtmlContent().indexOf("Ничего не найдено") >= 0){
			render(view: "not_found");
		}
		if(searchResult.getHtmlContent().indexOf("Указанный артикул") >= 0) {
			ExistCatalogParser parser = new ExistCatalogParser();
			ParseCatalogResult data = parser.parse(searchResult.getHtmlContent());
			print "Catalog data: ${data}"
			if(data == null || data.getParsedRows().size() < 1) {
				render(view: "not_found");
				return;
			}
			render(view: "catalog",model: [data: data.getParsedRows()]);
		}
		else {
			ExistParser parser = new ExistParser();
			ParseResult data = parser.parse(searchResult.getHtmlContent());
			print "Part number data: ${data}"
			if(data == null || data.getParsedRows().size() < 1) {
				render(view: "not_found");
				return;
			}
			render(view: "index",model: [data: data.getParsedRows()]);
		}
    }
	
	def catalog() {
		print "Catalog: ${request.getParameter('pid')}"
		if(request.getParameter('pid') == null){
			render(view: "not_found");
			return;
		}
		
		ExistSearch client = new ExistSearch();
		client.setByPid(true);
		SearchResult searchResult = client.makeSearch(request.getParameter('pid'));
		print "searchResult ${searchResult}"
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			render(view: "not_found");
		}
		if(searchResult.getHtmlContent().indexOf("Ничего не найдено") >= 0){
			render(view: "not_found");
		}
		
		ExistParser parser = new ExistParser();
		ParseResult data = parser.parse(searchResult.getHtmlContent());
		print "Part number data: ${data}"
		if(data == null || data.getParsedRows().size() < 1) {
			render(view: "not_found");
			return;
		}
		render(view: "index",model: [data: data.getParsedRows()]);	
	}
}
