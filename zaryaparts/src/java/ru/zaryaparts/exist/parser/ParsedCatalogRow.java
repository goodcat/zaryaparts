package ru.zaryaparts.exist.parser;

public class ParsedCatalogRow {
	private String firmName;
	private String articul;
	private String description;
	private String pid;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getPidProcessed () {
		return pid.substring(pid.lastIndexOf("=") + 1);
	}
	
	@Override
	public String toString() {
		return "ParsedCatalogRow [firmName=" + firmName + ", articul="
				+ articul + ", description=" + description + ", pid=" + pid
				+ "]";
	}
}
