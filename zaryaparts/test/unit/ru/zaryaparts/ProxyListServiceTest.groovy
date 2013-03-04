package ru.zaryaparts

import org.apache.commons.io.IOUtils;

class ProxyListServiceTest {
	def service = new ProxyListService()
	
	def testParsing() {
		def content = IOUtils.toString(new FileInputStream(new File("Z:/zaryaparts/zaryaparts/web-app/html/free-proxy-list.htm")), "UTF-8")
		service.loadProxyList(content)
	}

	public static void main(String[] args) {
		def test = new ProxyListServiceTest()
		test.testParsing()
	}
}
