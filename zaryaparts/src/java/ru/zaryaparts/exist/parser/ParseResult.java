package ru.zaryaparts.exist.parser;

import java.util.ArrayList;
import java.util.List;

public class ParseResult {
	private List<ParsedRow> parsedRows = new ArrayList<ParsedRow>();
	private ParseStatus parsingStatus = ParseStatus.NONE;
	
	public List<ParsedRow> getParsedRows() {
		return parsedRows;
	}
	public void setParsedRows(List<ParsedRow> parsedRows) {
		this.parsedRows = parsedRows;
	}
	public ParseStatus getParsingStatus() {
		return parsingStatus;
	}
	public void setParsingStatus(ParseStatus parsingStatus) {
		this.parsingStatus = parsingStatus;
	}
	@Override
	public String toString() {
		return "ParseResult [parsedRows=" + parsedRows + ", parsingStatus="
				+ parsingStatus + "]";
	}
	
	
}
