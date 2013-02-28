<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
	<title>ZaryaParts</title>
</head>
<body>
	<h1>Регистрация пользователя</h1>
	<g:form class="well" url="[controller: 'appUser', action: 'newUser']">
		<g:hasErrors bean="${user}">
			<g:eachError var="err" bean="${user}">
				<div class="alert alert-error"><g:message error="${err}" /></div>
			</g:eachError>
		</g:hasErrors>
		<fieldset>
			<legend>Новый пользователь</legend>
			
			<label for="email">Электронная почта</label>
			<div class="control-group ${hasErrors(bean:user,field:'email','error')}">
				<g:textField name="email" value="${user?.email}"/>
			</div>
			
			<label for="name">Имя</label>
			<div class="control-group ${hasErrors(bean:user,field:'name','error')}">
				<g:textField name="name" value="${user?.name}"/>
			</div>
			
			<label for="phone">Телефон</label>
			<div class="control-group ${hasErrors(bean:user,field:'phone','error')}">
				<g:textField name="phone" value="${user?.phone}"/>
			</div>
			
			<label for="password">Пароль</label>
			<div class="control-group ${hasErrors(bean:user,field:'password','error')}">
				<g:textField name="password" value=""/>
			</div>
			
			<label for="password">Подтвердите пароль</label>
			<div class="control-group ${hasErrors(bean:user,field:'passwordConfirm','error')}">
				<g:textField name="passwordConfirm" value=""/>
			</div>
			
			<div>
				<g:submitButton class="btn" name="submitButton" value="Регистрация" />
			</div>
		</fieldset>
	</g:form>
</body>
</html>