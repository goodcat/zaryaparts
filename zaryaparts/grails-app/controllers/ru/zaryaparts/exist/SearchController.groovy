package ru.zaryaparts.exist

import ru.zaryaparts.ParsingService;
import ru.zaryaparts.exist.http.*;
import ru.zaryaparts.exist.parser.*;

class SearchController {
	
	def searchService
	def parsingService
	
	def index() {
		def partNumber = request.getParameter('partNumber')
		log.info "search index: partNumber [${partNumber}]"
		def page = searchService.applySearch(partNumber)
		log.trace "page: ${page}"
		ParsingService.PAGE_TYPE pageType = parsingService.getPageType(page)
		log.info "pageType: ${pageType}"
		switch(pageType) {
			case ParsingService.PAGE_TYPE.DETAIL:
				Map params = parsingService.getPostMap(page)
				log.trace "params: ${params}"
				String pricedPage = searchService.applyPriceLevel(partNumber, params)
				ExistParser parser = new ExistParser()
				ParseResult data = parser.parse(pricedPage)
				log.trace "PAGE_TYPE.DETAIL | data: ${data}"
				if(data == null || data.getParsedRows().size() < 1) {
					log.warn "PAGE_TYPE.DETAIL: no data "
					render(view: "not_found");
					return;
				}
				render(view: "index", model: [data: data.getParsedRows()])
				return
			case ParsingService.PAGE_TYPE.CATALOG:
				ExistCatalogParser parser = new ExistCatalogParser()
				ParseCatalogResult data = parser.parse(page)
				log.trace "PAGE_TYPE.CATALOG | data: ${data}"
				if(data == null || data.getParsedRows().size() < 1) {
					log.warn "PAGE_TYPE.CATALOG: no data "
					render(view: "not_found");
					return;
				}
				render(view: "catalog", model: [data: data.getParsedRows()]);
				return
			default:
				log.warn "PAGE_TYPE.DEFAULT exit"
				render(view: "not_found")
				return
		}
	}
	
	def catalog() {
		def partNumber = request.getParameter('pid')
		log.info "catalog index: partNumber [${partNumber}]"
		def page = searchService.applySearch(partNumber, "pid")
		Map params = parsingService.getPostMap(page)
		String pricedPage = searchService.applyPriceLevel(partNumber, params, "pid")
		ParsingService.PAGE_TYPE pageType = parsingService.getPageType(pricedPage)
		if(pageType == ParsingService.PAGE_TYPE.DETAIL) {
			ExistParser parser = new ExistParser();
			ParseResult data = parser.parse(pricedPage);
			print "Part number data: ${data}"
			if(data == null || data.getParsedRows().size() < 1) {
				render(view: "not_found");
				return;
			}
			render(view: "index", model: [data: data.getParsedRows()]);
		}
		else {
			render(view: "not_found")
			return
		}
	}
}
