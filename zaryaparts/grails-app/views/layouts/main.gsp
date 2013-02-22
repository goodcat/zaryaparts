<!DOCTYPE html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="ZaryaParts"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
		<style>
			body {
        		padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      		}
      	</style>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
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
              				<li class="active"><a href="${createLink(uri: '/')}">Главная</a></li>
              				<li><a href="#about">О нас</a></li>
              				<li><a href="#contact">Контакты</a></li>
            			</ul>
         			 </div>
        			</div>
      			</div>
    		</div>
		<g:layoutBody/>
		<r:layoutResources />
		<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-1.9.1.js')}"></script>
		<script type="text/javascript" src="${resource(dir: 'js', file: 'bootstrap.js')}"></script>
	</body>
</html>
