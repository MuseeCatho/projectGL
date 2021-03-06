<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String mediaType = request.getParameter("mediaType");
	String mediaNamesString = request.getParameter("mediaNames");
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String mediaCarouselId = request.getParameter("mediaCarouselId");
	if (mediaType != null && mediaNamesString != null) {
		String[] mediaNames = mediaNamesString.split(",");
		//String mediaCarouselId = MD5.crypt(mediaType + mediaNames);
%>
<!-- <div class="mediaContainer">-->
<div id="<%=mediaCarouselId%>" class="mediaCarousel carousel slide"
	data-ride="carousel" style="width:<%=width%>;height:<%=height%>;">
	<!-- Carousel indicators -->
	<ol class="carousel-indicators">
		<%
			for (int i = 0; i < mediaNames.length; i++) {
		%>
		<li data-target="#<%=mediaCarouselId%>" data-slide-to="<%=i%>"
			<%if (i == 0) {%> class="active">
			<%
				}
			%>
		</li>
		<%
			}
		%>
	</ol>
	<!-- Carousel items -->
	<div class="carousel-inner">
		<%
			for (int i = 0; i < mediaNames.length; i++) {
		%>
		<div class="item <%if (i == 0) {%>active<%}%>">
			<div class="mediaCarousel_item" style="line-height:<%=height%>;">
				<%
					if (mediaType.equals("image")) {
				%>
				<!-- for an image : -->
				<img src="<%=mediaNames[i]%>" alt="slide <%=i + 1%>"
					data-toggle="modal" data-target="#<%=mediaCarouselId%>Modal<%=i%>" />
				<%
					} else if (mediaType.equals("audio")) {
				%>
				<!-- for an audio : -->
				<div class="audioContainer">
					<div class="ui360 ui360-vis" id="ren">
						<a href="<%=mediaNames[i]%>"></a>
					</div>
				</div>
				<%
					} else if (mediaType.equals("video")) {
				%>
				<!-- for a video : -->
				<div class="video-jsContainer">
					<video id="video<%=i%>" class="video-js vjs-default-skin" controls
						preload="none" width="500" height="300"
						poster="http://video-js.zencoder.com/oceans-clip.png"
						data-setup='{"example_option":true}'>
						<source src="<%=mediaNames[i]%>" type='video/mp4' />
						<p class="vjs-no-js">
							To view this video please enable JavaScript, and consider
							upgrading to a web browser that <a
								href="http://videojs.com/html5-video-support/" target="_blank">supports
								HTML5 video</a>
						</p>
					</video>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<!-- Controls -->
	<a class="left carousel-control" href="#<%=mediaCarouselId%>"
		role="button" data-slide="prev"> <span
		class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#<%=mediaCarouselId%>"
		role="button" data-slide="next"> <span
		class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>
<!-- modals : -->
<%
	if (mediaType.equals("image")) {
			for (int i = 0; i < mediaNames.length; i++) {
%>
<div class="modal fade" id="<%=mediaCarouselId%>Modal<%=i%>"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	aria-hidden="true">
	<div class="mediaModal modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<img src="<%=mediaNames[i]%>" />
			</div>
		</div>
	</div>
</div>
<%
	}
	}
	}
%>
<script>
			soundManager.setup({
				
				// where to find flash audio SWFs, as needed
				url: '/path/to/swf-files/',
				onready: function() {
					// SM2 is ready to play audio!
					var demo2Sound = soundManager.createSound({
						url: '12. - Real Evil - Henry Jackman & Matthew Margeson.mp3',
						onfinish: function() {
							soundManager._writeDebug(this.id + ' finished playing');
						}
					});
					demo2Sound.play({
						volume: 50
					});
					document.body.addEventListener('click',function(){
						console.log('click');
						var sound = soundManager.getSoundById('sound1');
						sound.setVolume(10);
					});
				}
			});
		</script>