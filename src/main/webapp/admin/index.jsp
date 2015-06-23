<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<s:include value="import.jsp"></s:include>
</head>
<body>
	
	<s:if test="%{#session.id_userAdmin!=null}">

	<s:include value="header_admin.jsp"></s:include>
	<s:include value="navigation.jsp">
		<s:param name="pageName">welcome</s:param>
	</s:include>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">TITRE</h1>
	</div>
	
	</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
</body>
</html>