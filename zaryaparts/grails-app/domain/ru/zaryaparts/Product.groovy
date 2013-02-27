package ru.zaryaparts

class Product {
	String firmName
	String articul
	String description
	BigDecimal price
	
	static belongsTo = [order: Order]

    static constraints = {
    }
	
	public String toString() {
		return this.firmName + " | " + articul + " | " + price
	}
}
