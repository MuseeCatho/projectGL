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
	<!-- The jPlayer div must not be hidden. Keep it at the root of the body element to avoid any such problems. -->
	<s:include value="mediaCarousel.jsp">
		<s:param name="mediaType">image</s:param>
		<s:param name="mediaNames">object_files/image/carousel1.jpg,object_files/image/carousel2.jpg,object_files/image/bas-relief.jpg</s:param>
		<s:param name="width">400px</s:param>
		<s:param name="height">300px</s:param>
		<s:param name="mediaCarouselId">mediaCarousel1</s:param>
	</s:include>
	<br/><br/>
	<s:include value="mediaCarousel.jsp">
		<s:param name="mediaType">video</s:param>
		<s:param name="mediaNames">object_files/video/shram.mp4,object_files/video/VIDEO0218.mp4</s:param>
		<s:param name="width">800px</s:param>
		<s:param name="height">400px</s:param>
		<s:param name="mediaCarouselId">mediaCarousel2</s:param>
	</s:include>
	<br/><br/>
	<s:include value="mediaCarousel.jsp">
		<s:param name="mediaType">audio</s:param>
		<s:param name="mediaNames">http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a</s:param>
		<s:param name="width">400px</s:param>
		<s:param name="height">300px</s:param>
		<s:param name="mediaCarouselId">mediaCarousel3</s:param>
	</s:include>
</body>
</html>