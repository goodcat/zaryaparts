package ru.zaryaparts

class Order {
	Date createDate
	
	static hasMany = [products: Product]
	static belongsTo = [user: AppUser]
	
	static mapping = {
		table 'z_order'
	}

    static constraints = {
    }
	
	@Override
	public String toString() {
		return this.user.email + " | " + createDate
	}
}
