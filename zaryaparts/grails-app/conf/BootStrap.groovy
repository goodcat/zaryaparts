import grails.util.GrailsUtil;
import ru.zaryaparts.AppUser;

class BootStrap {

	def init = { servletContext ->
		switch(GrailsUtil.current) {
			case "development":
				def adminUser = new AppUser()
				adminUser.setEmail('admin@zaryaparts.ru')
				adminUser.setPassword(HashCodec.encode('Admin_Passw1'))
				adminUser.setName('Test Test')
				adminUser.setPhone('111 11 11')
				adminUser.save()
				break;
		}
	}
	def destroy = {
	}
}
