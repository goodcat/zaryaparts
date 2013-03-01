package ru.zaryaparts

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;

class ParsingService {
	public Map<String, String> getPostMap(String htmlContent) {
		def params = new HashMap<String, String>()
		def doc = Jsoup.parse(htmlContent)
		def eventTargetElement = doc.getElementById("__EVENTTARGET")
		def viewStateElement = doc.getElementById("__VIEWSTATE")
		def eventValidationElement = doc.getElementById("__EVENTVALIDATION")
		def hiddenPidElement = doc.getElementById("hdnPid")
		params.put("__EVENTTARGET", 'ctl00$ctl00$b$b$ddlPriceLevel')
		params.put("__VIEWSTATE", viewStateElement.attr("value"))
		params.put("__EVENTVALIDATION", eventValidationElement.attr("value"))
		params.put('ctl00$ctl00$b$b$ddlPriceLevel', "1")
		params.put('ctl00$ctl00$b$b$hdnPid', hiddenPidElement?.attr("value"))
		return params
	}
	
	public PAGE_TYPE getPageType(String htmlContent) {
		if(htmlContent ==  null) {
			return PAGE_TYPE.NONE
		}
		if(htmlContent.indexOf("Найдено предложений") >= 0) {
			return PAGE_TYPE.DETAIL
		}
		if(htmlContent.indexOf("Указанный артикул") >= 0) {
			return PAGE_TYPE.CATALOG
		}
		if(htmlContent.indexOf("Ничего не найдено") >= 0) {
			return PAGE_TYPE.NOT_FOUND
		}
		return PAGE_TYPE.NONE
	}
	
	enum PAGE_TYPE {
		NONE,
		DETAIL,
		CATALOG,
		NOT_FOUND,
		LIMIT_REACHED
	}

	public static void main(String[] args) {
		def service = new ParsingService()

		def sample = new File('Z:/zaryaparts/zaryaparts/web-app/html/test_price.html')
		def httpContent = IOUtils.toString(new FileInputStream(sample))
		
		println service.getPostMap(httpContent)
		println service.getPageType(httpContent)
	}
}