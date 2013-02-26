<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>ZaryaParts</title>
</head>
<body>
	<div class="container">
		<g:if test="${data != null && data.size() > 0}">
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>Фирма</th>
						<th>Артикул</th>
						<th>Описание</th>
						<th>Цены и заменители</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${data}">
						<tr>
							<td>
								${it.firmName}
							</td>
							<td>
								${it.articul}
							</td>
							<td>
								${it.description}
							</td>
							<td><a href="<g:createLink action='catalog' params='[pid: "${it.pidProcessed}"]' />">Поиск</a></td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</g:if>
		<g:else>
			<p>Не найдено</p>
		</g:else>
	</div>

</body>
</html>