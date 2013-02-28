package ru.zaryaparts

class AppUser {
	String email
	String password
	String passwordConfirm
	String name
	String phone
	UserRoleEnum role
	
	static transients = ["passwordConfirm"]
	
	static hasMany = [orders: Order]

    static constraints = {
		email(unique: true, blank: false)
		password(password: true, blank: false)
		passwordConfirm(password: true, blank: false)
    }
	
	@Override
	public String toString(){
		return email
	}
}
