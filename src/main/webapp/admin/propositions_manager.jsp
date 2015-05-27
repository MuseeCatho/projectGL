<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<s:include value="import.jsp"></s:include>
</head>
<body>
	<s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="propositions_manager" />
	</jsp:include>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">Gestion des propositions de modification</h1>


	</div>
</body>
</html>