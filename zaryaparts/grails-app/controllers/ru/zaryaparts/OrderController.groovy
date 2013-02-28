package ru.zaryaparts

import org.springframework.dao.DataIntegrityViolationException

class OrderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def beforeInterceptor = [action:this.&auth, except: ['newOrder', 'deleteOrder']]
	
	def auth() {
		if(!session.user) {
		  redirect(controller:"login")
		  return false
		}
		if(UserRoleEnum.ADMIN != session.user.role) {
			redirect(controller:"login")
			return false
		}
	  }

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [orderInstanceList: Order.list(params), orderInstanceTotal: Order.count()]
    }

    def create() {
        [orderInstance: new Order(params)]
    }

    def save() {
        def orderInstance = new Order(params)
        if (!orderInstance.save(flush: true)) {
            render(view: "create", model: [orderInstance: orderInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)
    }

    def show(Long id) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def edit(Long id) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def update(Long id, Long version) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (orderInstance.version > version) {
                orderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'order.label', default: 'Order')] as Object[],
                          "Another user has updated this Order while you were editing")
                render(view: "edit", model: [orderInstance: orderInstance])
                return
            }
        }

        orderInstance.properties = params

        if (!orderInstance.save(flush: true)) {
            render(view: "edit", model: [orderInstance: orderInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)
    }

    def delete(Long id) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        try {
            orderInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def newOrder(String firmName, String articul, String description, String price) {	
		def user = session.user
		if(user == null) {
			flash.message = "Пользователь не найден"
			redirect(url: request.getHeader('referer'))
			return
		}
		
		def order = new Order()
		order.setCreateDate(new Date())
		order.appUser = user
		order.save()
		
		def product = new Product()
		product.setArticul(articul)
		product.setDescription(description)
		product.setFirmName(firmName)
		product.setPrice(new BigDecimal(extractPrice(price)))
		product.setOrder(order)
		product.save()
		
		redirect(controller: 'appUser', action: 'listOrders')
	}
	
	def deleteOrder(Long id) {
		def user = session.user
		if(user == null) {
			flash.message = "Пользователь не найден"
			redirect(url: request.getHeader('referer'))
			return
		}
		def order = Order.get(id)
		if(order.appUser.id.equals(user.id)) {
			order.delete()
			redirect(controller: 'appUser', action: 'listOrders')
		}
	}
	
	private static String extractPrice(String price){
		if(price == null) return "0"
		StringBuilder buffer = new StringBuilder()
		for(char c in price.toCharArray()) {
			if(String.valueOf(c) =~ /\d/) {
				buffer.append(c)
			}
			if(c == ',') {
				buffer.append(".")
			}
		}
		if(buffer.size() < 1) return "0"
		return buffer.toString()
	}
	
	public static void main(String[] args) {
		println extractPrice("1 153,18р.")
		println new BigDecimal(extractPrice("1 153,18р."))
		println new BigDecimal(extractPrice("---"))
	}
}
