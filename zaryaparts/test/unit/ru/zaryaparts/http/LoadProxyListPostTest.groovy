package ru.zaryaparts.http

import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import ru.zaryaparts.HttpService

class LoadProxyListPostTest {
	public static void main(String[] args) {
		def content = new HttpService().postPage("http://spys.ru/en/free-proxy-list/",
			["sto": "View+150+per+page"])
		print content
	}
}