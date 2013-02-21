package ru.zaryaparts.exist.parser;

import java.util.ArrayList;
import java.util.List;

public class ParseResult {
	private List parsedRows = new ArrayList();
	private ParseStatus parsingStatus = ParseStatus.NONE;
	
	public List getParsedRows() {
		return parsedRows;
	}
	public void setParsedRows(List parsedRows) {
		this.parsedRows = parsedRows;
	}
	public ParseStatus getParsingStatus() {
		return parsingStatus;
	}
	public void setParsingStatus(ParseStatus parsingStatus) {
		this.parsingStatus = parsingStatus;
	}
	
	
}
