package ru.zaryaparts.exist

import ru.zaryaparts.exist.http.*;
import ru.zaryaparts.exist.parser.*;

class SearchController {

    def index() { 
    	print "Search: ${request.getParameter("partNumber")}"
    	
    	ExistSearch client = new ExistSearch();
		SearchResult searchResult = client.makeSearch(request.getParameter("partNumber"));
		if(SearchStatus.SUCCESS != searchResult.getSearchStatus()){
			render(view: "index",model: [data: null]);
		}
		ExistParser parser = new ExistParser();
		ParseResult data = parser.parse(searchResult.getHtmlContent());
		render(view: "index",model: [data: data.getParsedRows()]);
    }
}
