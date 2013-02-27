<%@ page import="ru.zaryaparts.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'articul', 'error')} ">
	<label for="articul">
		<g:message code="product.articul.label" default="Articul" />
		
	</label>
	<g:textField name="articul" value="${productInstance?.articul}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${productInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'firmName', 'error')} ">
	<label for="firmName">
		<g:message code="product.firmName.label" default="Firm Name" />
		
	</label>
	<g:textField name="firmName" value="${productInstance?.firmName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'order', 'error')} required">
	<label for="order">
		<g:message code="product.order.label" default="Order" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="order" name="order.id" from="${ru.zaryaparts.Order.list()}" optionKey="id" required="" value="${productInstance?.order?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="product.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: productInstance, field: 'price')}" required=""/>
</div>

