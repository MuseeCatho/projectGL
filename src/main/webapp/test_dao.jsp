<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:iterator value="results">
		<p>
			user : <s:property value="id"/> :<br/>
			---- name : <s:property value="firstname"/>
		</p>
	</s:iterator>
</body>
</html>