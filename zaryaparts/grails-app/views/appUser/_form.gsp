<%@ page import="ru.zaryaparts.AppUser" %>



<div class="fieldcontain ${hasErrors(bean: appUserInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="appUser.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${appUserInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: appUserInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="appUser.password.label" default="Password" />
		
	</label>
	<g:field type="password" name="password" value="${appUserInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: appUserInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="appUser.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${appUserInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: appUserInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="appUser.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" value="${appUserInstance?.phone}"/>
</div>

