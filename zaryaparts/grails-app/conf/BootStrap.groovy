import grails.util.Environment;
import grails.util.GrailsUtil;
import ru.zaryaparts.AppUser;
import ru.zaryaparts.HashCodec;
import ru.zaryaparts.UserRoleEnum;

class BootStrap {

	def init = { servletContext ->
		switch(Environment.getCurrent()) {
			case Environment.DEVELOPMENT:
			case Environment.PRODUCTION:
				def adminUser = new AppUser()
				adminUser.setEmail('admin@zaryaparts.ru')
				adminUser.setPassword(HashCodec.encode('Admin_Passw1'))
				adminUser.setName('Test Test')
				adminUser.setPhone('111 11 11')
				adminUser.setRole(UserRoleEnum.ADMIN)
				adminUser.save()
				
				def customer = new AppUser()
				customer.setEmail('customer@zaryaparts.ru')
				customer.setPassword(HashCodec.encode('Customer_Passw1'))
				customer.setName('Some Body')
				customer.setPhone('111 22 22')
				customer.setRole(UserRoleEnum.CUSTOMER)
				customer.save()
				break;
		}
	}
	def destroy = {
	}
}
