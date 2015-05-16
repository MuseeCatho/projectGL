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
	<s:include value="mediaCarousel.jsp">
		<s:param name="mediaType">image</s:param>
		<s:param name="mediaNames">object_files/image/carousel1.jpg,object_files/image/carousel2.jpg,object_files/image/bas-relief.jpg</s:param>
		<s:param name="width">800px</s:param>
		<s:param name="height">600px</s:param>
		<s:param name="mediaCarouselId">mediaCarousel1</s:param>
	</s:include>
</body>
</html>