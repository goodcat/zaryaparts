package ru.zaryaparts

import java.net.URLEncoder;
import org.apache.commons.logging.LogFactory;

class SearchService {
	private final static log = LogFactory.getLog(SearchService.class)
	
	public final static String EXIST_ENTRY_POINT = "http://exist.ru/price.aspx"
	
	def httpService
	
	def applySearch(partNumber, paramName = "pcode") {
		log.info "applyPCodeSearch | partNumber [${partNumber}]"
		def url = EXIST_ENTRY_POINT + "?" + paramName + "=" + URLEncoder.encode(partNumber, "UTF-8")
		log.trace "url: ${url}"
		def page = httpService.getPage(url)
		return page
	}
	
	def applyPriceLevel(partNumber, Map params, paramName = "pcode") {
		log.info "applyPriceLevel | ${partNumber}"
		def url = EXIST_ENTRY_POINT + "?" + paramName + "=" + URLEncoder.encode(partNumber, "UTF-8")
		log.trace "url: ${url}"
		def page = httpService.postPage(url, params)
		return page
	}

	public static void main(String[] args) {
		def service = new SearchService()
		service.httpService = new HttpService()
		print service.applySearch("15208-9F600")
	}
}