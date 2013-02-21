package ru.zaryaparts.exist.parser;

public class ParsedRow {
	private String firmName;
	private String articul;
	private String description;
	private String information;
	private String count;
	private String period;
	private String price;
	
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getArticul() {
		return articul;
	}
	public void setArticul(String articul) {
		this.articul = articul;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParsedRow [firmName=").append(firmName)
				.append(", articul=").append(articul).append(", description=")
				.append(description).append(", information=")
				.append(information).append(", count=").append(count)
				.append(", period=").append(period).append(", price=")
				.append(price).append("]");
		return builder.toString();
	}
	
	
}
