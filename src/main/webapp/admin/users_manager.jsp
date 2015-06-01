<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Gestion des membres</title>
	<s:include value="import.jsp"></s:include>
	<link href="./css/main.css" rel="stylesheet">
</head>
<body>
	<s:include value="header_admin.jsp"></s:include>
	<s:include value="navigation.jsp">
		<s:param name="pageName">users_manager</s:param>
	</s:include>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">Gestion des membres</h1>
		<input id="searchInput" type="text"/>
		<select id="adminInput"> 
   			<option value="1">administrateur</option> 
   			<option value="0">non administrateur</option> 
		</select>
		<div id="usersDiv"></div>
	</div>
</body>
</html>

<script>
	var language = 'french';
</script>
<script src = "js/users_manager.js"></script>