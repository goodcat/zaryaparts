<%@ page import="ru.zaryaparts.Order" %>



<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'createDate', 'error')} required">
	<label for="createDate">
		<g:message code="order.createDate.label" default="Create Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createDate" precision="day"  value="${orderInstance?.createDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'products', 'error')} ">
	<label for="products">
		<g:message code="order.products.label" default="Products" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${orderInstance?.products?}" var="p">
    <li><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="product" action="create" params="['order.id': orderInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="order.appUser.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${ru.zaryaparts.AppUser.list()}" optionKey="id" required="" value="${orderInstance?.user?.id}" class="many-to-one"/>
</div>

