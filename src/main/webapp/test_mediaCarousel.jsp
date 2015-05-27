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
	<s:include value="mediaCarousel.jsp">
		<s:param name="mediaType">video</s:param>
		<s:param name="mediaNames">object_files/video/shram.mp4,object_files/video/VIDEO0218.mp4</s:param>
		<s:param name="width">800px</s:param>
		<s:param name="height">600px</s:param>
		<s:param name="mediaCarouselId">mediaCarousel2</s:param>
	</s:include>
	
	<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
      poster="http://video-js.zencoder.com/oceans-clip.png"
      data-setup="{}">
    <source src="http://video-js.zencoder.com/oceans-clip.mp4" type='video/mp4' />
    <source src="http://video-js.zencoder.com/oceans-clip.webm" type='video/webm' />
    <source src="http://video-js.zencoder.com/oceans-clip.ogv" type='video/ogg' />
    <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
  </video>
</body>
</html>