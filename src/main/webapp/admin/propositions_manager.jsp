<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
<s:include value="import.jsp"></s:include>
</head>
<body>
<s:if test="%{#session.id_user!=null}">

	<s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="propositions_manager" />
	</jsp:include>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">Gestion des propositions de modification</h1>
		<table class="table table-condensed" id="tabPeriod">
			<thead>
				<tr>
					<th>Image</th>
					<th>Nom de l'oeuvre</th>
					<th>Date</th>
					<th>Nombre de demande de modification</th>
					<th>Details</th>
				</tr>
			</thead>
			<tbody>azsdfghj
			<s:iterator value="arrayListObject">asdfghjk
					<s:property value="number" />
			</s:iterator>
			</tbody>
		</table>

	</div>
	
	
</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
</body>
</html>