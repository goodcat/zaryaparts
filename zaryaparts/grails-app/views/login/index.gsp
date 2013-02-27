<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>ZaryaParts</title>
</head>
<body>
	<div class="row">
		<div class="span4 offset2">
			<div class="well">
				<legend>Войти в учетную запись</legend>
				<g:form action="authenticate" method="post">
					<g:if test="${flash.message}">
						<div class="alert alert-error">
							${flash.message}
						</div>
					</g:if>
					<input class="span3" placeholder="Username" type="text" name="username">
					<input class="span3" placeholder="Password" type="password" name="password">
					<button class="btn-info btn" type="submit">Войти</button>
				</g:form>
			</div>
		</div>
	</div>
</body>
</html>