package ru.zaryaparts.exist.http;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class ExistSearch {
	Logger LOG = Logger.getLogger(ExistSearch.class);
	
	private static final String EXIST_SEARCH_ENTRY_POINT = "http://exist.ru/price.aspx";
	
	private boolean byPid = false;
	
	public SearchResult makeSearch(String partNumber) {
		LOG.info("Make search, partNumber is " + partNumber);
		SearchResult result = new SearchResult();
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String searchUrl = existSearchUrl(partNumber);
		System.out.println("searchUrl: " + searchUrl);
		if(searchUrl == null){
			result.setSearchStatus(SearchStatus.FAILURE);
			return result;
		}
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
	
	private String existSearchUrl(String partNumber) {
		try {
			if (this.byPid) {
				return EXIST_SEARCH_ENTRY_POINT + "?pid=" + URLEncoder.encode(partNumber, "UTF-8");
			} else {
				return EXIST_SEARCH_ENTRY_POINT + "?pcode=" + URLEncoder.encode(partNumber, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			LOG.error("Error while encoding search URL ", e);
			return null;
		}
	}
	
	public void setByPid(boolean byPidFlag) {
		this.byPid = byPidFlag;
	}
}
