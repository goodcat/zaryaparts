package ru.zaryaparts

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class ProxyListService {
	def httpService

    public List loadProxyList(String htmlContent) {
		def doc = Jsoup.parse(htmlContent)
		def rows = doc.select("tr[class=spy1xx]")
		def script = variablesScript(doc)
		println script
		for(Element row in rows) {
			Elements cells = row.select("td")
			Element ipCell = cells[0]
			Element typeCell = cells[1]
			parseIpAndPort(ipCell)
		}
    }
	
	private String variablesScript(Element doc) {
		Elements scripts = doc.select("script")
		return scripts[3].children()[0]
	}
	
	private String parseIpAndPort(Element cell) {
		def fonts = cell.select("font")
		def ipFont = fonts[1]
		print ipFont.text()
		def script = String.valueOf(ipFont.select("script"))
		def expr = script.substring(script.indexOf("/font>\"+") + 8,
			script.indexOf("</script>") - 1)
		println " | " + expr
	}
}
