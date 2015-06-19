<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<s:include value="loadScripts.jsp"></s:include>
<!--  load media scripts -->
<s:include value="mediaElementsRequired.jsp"></s:include>
<title>Museum</title>
</head>
<body>
	<s:set name="pageNumber" value="4"/>
	<s:property value="#pageNumber"/>
	<s:include value="admin/pagination.jsp"></s:include>
</body>
</html>