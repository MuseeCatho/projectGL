<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String mediaType = request.getParameter("mediaType");
	String mediaRepository = request.getParameter("mediaRepository");
	String mediaNamesString = request.getParameter("mediaNames");
	if (mediaType != null && mediaRepository != null
			&& mediaNamesString != null) {
		String[] mediaNames = mediaNamesString.split(",");
		//String mediaCarouselId = MD5.crypt(mediaType + mediaNames);
		String mediaCarouselId = mediaType;
%>

<!-- <div class="mediaContainer">-->

<div>
	<div id="<%=mediaCarouselId%>" class="mediaCarousel carousel slide"
		data-ride="carousel">
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
				<%
					if (mediaType.equals("image")) {
				%>
				<!--  for an image : -->
				<img src="<%=mediaRepository + "/" + mediaNames[i]%>"
					alt="slide <%=i + 1%>" data-toggle="modal"
					data-target="#<%=mediaCarouselId%>Modal<%=i%>" />
				<%
					} else if (mediaType.equals("audio")) {
				%>
				<!--  for an audio : -->

				<%
					} else if (mediaType.equals("video")) {
				%>
				<!--  for a video : -->
				<div class="video-jsContainer">
					<video id="video<%=i%>" class="video-js vjs-default-skin" controls
						preload="auto"
						poster="http://video-js.zencoder.com/oceans-clip.png"
						data-setup='{"example_option":true}'>
						<source src="<%=mediaRepository + "/" + mediaNames[i]%>" type='video/mp4' />
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
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

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
				<img src="<%=mediaRepository + "/" + mediaNames[i]%>"/>
			</div>
		</div>
	</div>
</div>
<%
	}
		}
	}
%>