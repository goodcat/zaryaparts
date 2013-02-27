
<%@ page import="ru.zaryaparts.AppUser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'appUser.label', default: 'AppUser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-appUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-appUser" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="email" title="${message(code: 'appUser.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'appUser.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'appUser.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="phone" title="${message(code: 'appUser.phone.label', default: 'Phone')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${appUserInstanceList}" status="i" var="appUserInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${appUserInstance.id}">${fieldValue(bean: appUserInstance, field: "email")}</g:link></td>
					
						<td>${fieldValue(bean: appUserInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: appUserInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: appUserInstance, field: "phone")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${appUserInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
