package ru.zaryaparts.exist.http;

public class SearchResult {
	private String htmlContent;
	private SearchStatus searchStatus = SearchStatus.NONE;

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public SearchStatus getSearchStatus() {
		return searchStatus;
	}

	public void setSearchStatus(SearchStatus searchStatus) {
		this.searchStatus = searchStatus;
	}

	@Override
	public String toString() {
		return "SearchResult [htmlContent="
				+ (htmlContent == null ? "NULL" : htmlContent.substring(0, 1024)) + ", searchStatus=" + searchStatus
				+ "]";
	}

}
