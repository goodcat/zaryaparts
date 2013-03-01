<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="ZaryaParts" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="${resource(dir: 'images', file: 'favicon.ico')}"
	type="image/x-icon">
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}"
	type="text/css">
<g:layoutHead />
<r:layoutResources />
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="brand" href="${createLink(uri: '/')}">Zarya Parts</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Новости</a></li>
						<li><a href="#">О компании</a></li>
						<li><a href="#">Доставка</a></li>
						<li><a href="#">Запчасти</a></li>
						<li><a href="#">Поставщикам</a></li>
						<li><a href="#">Вакансии</a></li>
						<li><a href="#">Контакты</a></li>
					</ul>

					<ul class="nav pull-right">
						<g:if test="${session.user == null}">
							<li><g:link controller='login'>Войти</g:link></li>
							<li><g:link controller='appUser' action='register'>Регистрация</g:link></li>
						</g:if>
						<g:else>
							<li>
								<div class="btn-group">
                					<button class="btn">${session.user.email}</button>
                					<button class="btn dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
                					<ul class="dropdown-menu">
                  						<li><g:link controller="appUser" action="listOrders">Заказы</g:link></li>
                					</ul>
              					</div>
							<li><g:link controller='login' action='logout'>Выйти</g:link></li>
						</g:else>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<g:if test="${flash.message}">
		<div class="well">
			${flash.message}
		</div>
	</g:if>
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="span2">
					<g:render template="/news"></g:render>
				</div>
				<div class="span10">
					<g:layoutBody />
				</div>
			</div>
		</div>
	</div>
	<r:layoutResources />
	<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-1.9.1.js')}"></script>
	<script type="text/javascript" src="${resource(dir: 'js', file: 'bootstrap.js')}"></script>
</body>
</html>
