<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Profil</title>
	<s:include value="import.jsp"></s:include>
</head>
<body>

<s:if test="%{#session.id_userAdmin!=null}">

	<s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="profile_manager" />
	</jsp:include>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">GESTION DE PROFIL</h1>

</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>

	</div>
</body>
</html>