package ru.zaryaparts

import ru.zaryaparts.HashCodec

class LoginController {

	def index() {
	}

	def authenticate() {
		String rawPassword = params.password == null ? "" : params.password;
		String password = HashCodec.encode(rawPassword)
		def user = AppUser.findByEmailAndPassword(params.username, password)
		if(user){
			session.user = user
			flash.message = "Вы вошли как ${user.name}"
			redirect(controller: '/')
		}
		else{
			flash.message = "Неправильно введены имя пользователя или пароль"
			redirect(controller: 'login')
		}
	}
	
	def logout() {
		flash.message = "До свиданья, ${session.user.name}"
		session.user = null
		redirect(view: 'index')
	}
}
