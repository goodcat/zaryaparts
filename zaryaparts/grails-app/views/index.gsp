<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		<title>ZaryaParts</title>
	</head>
	<body>
    <div class="container">

      <h1>Магазин автозапчастей</h1>
      <p>
      	<g:form name="searchForm" url="[action:'index',controller:'search']" class="well form-search">
      		<label>Поиск по номеру: </label>
      		<input type="text" name="partNumber" class="input-medium search-query">
      		<button type="submit" class="btn">Искать</button>
      	</g:form>
      </p>

    </div>
    
	</body>
</html>
