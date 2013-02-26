package ru.zaryaparts

class AppUser {
	String email
	String password
	String name
	String phone

    static constraints = {
		email(unique: true)
		password(password: true)
    }
	
}
