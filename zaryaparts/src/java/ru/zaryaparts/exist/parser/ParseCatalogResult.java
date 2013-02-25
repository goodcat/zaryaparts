package ru.zaryaparts.exist.parser;

import java.util.ArrayList;
import java.util.List;

public class ParseCatalogResult {
	private List<ParsedCatalogRow> parsedRows = new ArrayList<ParsedCatalogRow>();
	private ParseStatus parsingStatus = ParseStatus.NONE;
	
	public List<ParsedCatalogRow> getParsedRows() {
		return parsedRows;
	}
	public void setParsedRows(List<ParsedCatalogRow> parsedRows) {
		this.parsedRows = parsedRows;
	}
	public ParseStatus getParsingStatus() {
		return parsingStatus;
	}
	public void setParsingStatus(ParseStatus parsingStatus) {
		this.parsingStatus = parsingStatus;
	}
	
	
}
