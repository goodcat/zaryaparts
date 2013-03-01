<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		<title>ZaryaParts</title>
	</head>
	<body>
	
	<p>
		<g:render template="/search"></g:render>
	</p>

	<g:if test="${data != null && data.size() > 0}">
		<table class="table table-striped table-bordered table-condensed table-hover">
		<thead>
		<tr>
		<th>Фирма</th>
		<th>Артикул</th>
		<th>Описание</th>
		<th>Инф.</th>
		<th>Нал.</th>
		<th>Ожидаемый срок, дн.</th>
		<th>Цена</th>
		<th>&nbsp;</th>
		</tr>
		</thead>
		<tbody>
     	<g:each in="${data}">
     		<tr>
    		<td>${it.firmName}</td>
    		<td>${it.articul}</td>
    		<td>${it.description}</td>
    		<td>${it.information}</td>
    		<td>${it.count}</td>
    		<td>${it.period}</td>
    		<td>${it.price}</td>
    		<td>
    		<g:if test="${session.user}">
    		<g:link controller="order" action="newOrder" 
    		params='[firmName: "${it.firmName}",
    				articul: "${it.articul}",
    				description: "${it.description}",
    				price: "${it.price}"]' title="Заказать">+</g:link>
    		</g:if>
    		<g:else>
    		+
    		</g:else>		
    		</td>
    		</tr>
		</g:each>
		</tbody>
		</table>
	</g:if>
	<g:else>
		<p>Не найдено</p>
	</g:else>
    
	</body>
</html>
