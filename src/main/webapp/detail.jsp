<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>
<script src="js/comment.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/mediaCarousel.css">
<link rel="stylesheet" href="css/detail.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Oeuvre</title>
</head>
<body id="bodyDetail">

	<div id="container">
		<s:include value="header.jsp"></s:include>

		<div class="row" id="header">

			<s:iterator value="listDetailPage">

				<div class="row" id="header-object">
					<h1>
						Oeuvre <span id="titleDetail"><s:property value="title_f" /></span>
					</h1>
					<div id="modification">
						<input type=button class="btn btn-primary navbar-btn" role="button" value="Proposer une modification" id="buttonChange" onClick="hideEnr();">
					</div>
				</div>
				<div class="row">
					<div class="col-md-8">
						<div id="carouselPhotos">
							<s:include value="mediaCarousel.jsp">
								<s:param name="mediaType">image</s:param>
								<s:param name="mediaNames">
									<s:property value="link_photos" />
								</s:param>
							</s:include>
						</div>
						<div id="listPhotos">
							<div class="tablecell">
								<s:iterator value="listDetail">
									<div id="photoDetail">
										<img id="listPhotosImg"	src="<s:property value="link_photos"/>"	class="img-responsive" alt="Responsive image"> 
										<a class="cursor_delete" onmouseover=""	onclick="addProposition('image', <s:property value="id"/>,'delete')"><img class="cancel_category" src="img/icon/cancel.png" width="30" height="30"></a>
									</div>
								</s:iterator>
							</div>
							<div id="ajoutImage">
								<input type=button class="btn btn-primary navbar-btn"
									role="button" value="Ajouter une image" >
							</div>
						</div>
						<div class="panel panel-default" id="descriptionDetail">
							<div class="panel-heading">Description</div>
							<div class="panel-body">
								<s:property value="description_f" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div id="video">
							<h4>Regarder la vidéo de l'objet :</h4>
							<iframe width="400" height="225"
								src="https://www.youtube.com/embed/LqTyPFFS8fg" frameborder="0"
								allowfullscreen></iframe>
						</div>

						<div id="video" class="videoDetail">
							<h4>Regarder la vidéo de l'objet :</h4>

							<iframe width="400" height="225"
								src="https://www.youtube.com/embed/LqTyPFFS8fg" frameborder="0"
								allowfullscreen></iframe>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<div id="image3DDetail">
							<h1>Image 3d</h1>
						</div>
					</div>

				</div>
			</s:iterator>
			<hr>
		<s:if test="%{#session.firstname!=null}">
			<div class="row">
				<div class="col-lg-5 col-lg-offset-1">
					<!-- Comments Form -->
					<div class="well">
						<h4>Leave a Comment:</h4>
						<form role="form">
							<div class="form-group">
								<textarea class="form-control" rows="3" id="commentObject"></textarea>
							</div>
							<button type="button" class="btn btn-primary"
								onclick="addComment(<s:property value="#session.id_user"/>);">Submit</button>
						</form>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-5 col-lg-offset-1">

					<s:iterator value="listCommentAndNameUser">
						<div class="media">
							<div class="media-body">
								<h4 class="media-heading">
									<s:property value="pseudo" />
									<small><s:date name="date" format="dd/MM/yyyy" /> � <s:date
											name="date" format="hh:mm:ss" /></small>
								</h4>
								<s:property value="text" />
							</div>
						</div>
					</s:iterator>
				</div>
			</div>
	</div>
	</s:if>
		</div>
		




	<s:include value="footer.jsp"></s:include>

	</div>
	<script src="js/enrichissement.js"></script>
</body>
</html>