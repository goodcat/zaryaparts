package ru.zaryaparts.parser;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.*;
import java.io.*;

public class ExistParser {
	public static void main(String[] args) throws Exception {
		File input = new File("D:/sites/zaryaparts/doc/Orig Toyota.htm");
		Document doc = Jsoup.parse(input, "UTF-8");

		Elements rows = doc.select("tr[id]");
		for (Element row : rows) {
			String rowId = row.attr("id");
			Elements columns = row.select("td");
			System.out.println("Read row: " + rowId);
			for(Element column : columns) {
				System.out.print("td: " + column.text() + " | ");
			}
			System.out.println();
		}
	}
}