package ru.zaryaparts

import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair

class HttpService {
	def getPage(String url) {
		def httpClient = new DefaultHttpClient()
		def searchRequest = new HttpGet(url);
		def response = httpClient.execute(searchRequest)
		def responseEntity = response.getEntity()
		def httpContent = IOUtils.toString(responseEntity.getContent(), "UTF-8")
		return httpContent
	}
	
	def postPage(String url, Map<String, String> params) {
		def client = new DefaultHttpClient()
		def post = new HttpPost(url)
		def nameValuePairs = new ArrayList<NameValuePair>()
		params.each {k, v -> nameValuePairs.add(new BasicNameValuePair(k, v)) }
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs))

		def response = client.execute(post)
		def httpContent = IOUtils.toString(response.getEntity().getContent(), "UTF-8")
		return httpContent
	}
	
	public static void main(String[] args) {
		def service = new HttpService()
		print service.getPage("http://exist.ru")
	}
}