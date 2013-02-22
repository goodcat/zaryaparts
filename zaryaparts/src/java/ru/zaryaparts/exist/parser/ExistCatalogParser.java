package ru.zaryaparts.exist.parser;

import org.apache.log4j.Logger;

public class ExistCatalogParser implements IParser {
	Logger LOG = Logger.getLogger(ExistCatalogParser.class);

	@Override
	public ParseResult parse(String htmlContent) {
		ParseResult data = new ParseResult();
		if (htmlContent == null){
			LOG.warn("htmlContent for parsing is empty");
			return data;
		}
		return null;
	}

}
