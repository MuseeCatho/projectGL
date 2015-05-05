<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String mediaType = request.getParameter("mediaType");
	String[] mediaNames = request.getParameter("mediaNames").split(",");
	//String mediaCarouselId = MD5.crypt(mediaType + mediaNames);
	String mediaCarouselId = mediaType;
%>

<div class="mediaContainer">
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
				<img src="img/<%=mediaNames[i]%>" alt="slide <%=i + 1%>"
					<%if (mediaType.equals("image")) {%> data-toggle="modal"
					data-target="#<%=mediaCarouselId%>Modal<%=i%>" <%}%> />
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
				<img src="img/<%=mediaNames[i]%>" alt="slide <%=i + 1%>" />
			</div>
		</div>
	</div>
</div>
<%
	}
	}
%>