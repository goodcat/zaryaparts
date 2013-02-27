package ru.zaryaparts

class AppUser {
	String email
	String password
	String name
	String phone
	UserRoleEnum role
	
	static hasMany = [orders: Order]

    static constraints = {
		email(unique: true)
		password(password: true)
    }
	
	@Override
	public String toString(){
		return email
	}
}
