<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		<title>ZaryaParts</title>
	</head>
	<body>
	<h1>Заказы</h1>
	<g:if test="${orders}">
		<table class="table table-striped table-bordered table-condensed table-hover">
			<thead>
				<tr>
					<th>Дата заказа</th>
					<th>Фирма</th>
					<th>Описание</th>
					<th>Артикул</th>
					<th>Цена</th>
				</tr>
			</thead>
			<tbody>
		<g:each in="${orders}" var="order">
				<tr>
					<td>${order[0]}</td>
					<td>${order[1]}</td>
					<td>${order[2]}</td>
					<td>${order[3]}</td>
					<td>${order[4]}</td>
				</tr>
		</g:each>
			</tbody>
		</table>
	</g:if>
	</body>
</html>