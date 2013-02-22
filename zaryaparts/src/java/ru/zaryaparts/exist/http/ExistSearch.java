package ru.zaryaparts.exist.http;

import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class ExistSearch {
	Logger LOG = Logger.getLogger(ExistSearch.class);
	
	public SearchResult makeSearch(String partNumber) {
		LOG.info("Make search, partNumber is " + partNumber);
		SearchResult result = new SearchResult();
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String searchUrl;
		try{
			searchUrl = "http://exist.ru/price.aspx?pcode=" + URLEncoder.encode(partNumber, "UTF-8");
		}
		catch(Exception e){
			throw new RuntimeException("Error while encoding search URL");
		}
		System.out.println("searchUrl: " + searchUrl);
		HttpGet searchRequest = new HttpGet(searchUrl);
		HttpResponse response = null;
		try{
			response = httpClient.execute(searchRequest);
		}
		catch(Exception e){
			LOG.error("Error while executing search request", e);
			result.setSearchStatus(SearchStatus.FAILURE);
			return result;
		}
		if(response == null) {
			LOG.warn("Response is NULL");
			result.setSearchStatus(SearchStatus.FAILURE);
			return result;
		}
		HttpEntity responseEntity = response.getEntity();
		String httpContent = null;
		try{
			InputStream stream = responseEntity.getContent();
			httpContent = IOUtils.toString(stream);
		}
		catch(Exception e){
			LOG.error("Error while reading response", e);
			result.setSearchStatus(SearchStatus.FAILURE);
			return result;
		}
		if(httpContent != null) {
			result.setHtmlContent(httpContent);
			result.setSearchStatus(SearchStatus.SUCCESS);
		}
		else{
			result.setSearchStatus(SearchStatus.FAILURE);
		}
		return result;
	}
}
