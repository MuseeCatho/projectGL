<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Gestion des membres</title>
<s:include value="import.jsp"></s:include>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/users_manager.css" rel="stylesheet" type="text/css">
<link href="./css/alert.css" rel="stylesheet" type="text/css">
</head>
<body>
	<s:if test="%{#session.id_userAdmin!=null}">
	
	<s:include value="header_admin.jsp"></s:include>
	<s:include value="navigation.jsp">
		<s:param name="pageName">users_manager</s:param>
	</s:include>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">Gestion des membres</h1>
		<form class="form-inline" role="form">
			<div class="checkbox">
				<label for="searchInput">Rechercher un utilisateur ou un
					administrateur : </label> <input id="searchInput" type="text"
					class="form-control" placeholder="recherche" />
			</div>
			<div class="checkbox">
				<select id="adminInput" class="form-control">
					<option value="0">non administrateur</option>
					<option value="1">administrateur</option>
				</select>
			</div>
			<div class="checkbox">
				<select id="banInput" class="form-control">
					<option value="0">non bannis</option>
					<option value="1">bannis</option>
				</select>
			</div>
		</form>
		<div id="usersDiv"></div>
	</div>
</div>
</div>


</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
</body>
</html>

<script>
	var language = 'french';
</script>
	<script src="js/users_manager.js"></script>
	<script src="js/alert.js"></script>