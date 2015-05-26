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
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10" id="header">
				<s:iterator value="listDetailPage">

					<div class="row" id="header-object">
						<div class="col-sm-10">
							<h1>
								Oeuvre <span id="titleDetail"><s:property value="title_f" /></span>
							</h1>
						</div>
						<div class=col-sm-2>
							<div>
								<aside class="modification"> <input type=button
									class="btn btn-primary navbar-btn bouttonModification"
									role="button" value="Proposer une modification"
									id="buttonChange"
									onClick="hideEnr(<s:property value="#session.id_user"/>);">
								</aside>
								<aside id="annulationProposition" class="modification">
								<input type=button
									class="btn btn-primary navbar-btn bouttonModification"
									role="button" value="Annuler" onClick="annulation();">
								</aside>
							</div>
						</div>


						<div>
							<div class="col-md-8">
								<aside class="row">
									<div id="carouselPhotos">
										<s:include value="mediaCarousel.jsp">
											<s:param name="mediaType">image</s:param>
											<s:param name="mediaNames">
												<s:property value="link_photos" />
											</s:param>
											<s:param name="height">400px</s:param>
										</s:include>
									</div>
									<div id="listPhotos">
										<div class="tablecell" class="row">
											<s:iterator value="listDetail">
												<div id="photoDetail" class="col-xs-4 col-sm-3 col-md-2 ">
													<img border-color="blue" id="listPhotosImg"
														src="<s:property value="link_photos"/>"
														alt="Responsive image"> <a class="cursor_ok"
														onclick="cancelProposition('image',<s:property value="id"/>)">
														<img alt="alternativtext" class="icon icon_ok"
														" src="img/icon/ok.png"
														id="icon_ok<s:property value="id"/>" width="30"
														height="30">
													</a> <a class="cursor_delete"
														onclick="addProposition('image', <s:property value="id"/>,'delete')">
														<img alt="alternativtext" class="icon icon_cancel"
														src="img/icon/cancel.png"
														id="icon_cancel<s:property value="id"/>" width="30"
														height="30">
													</a>
												</div>
											</s:iterator>
										</div>
										<div id="ajoutImage">
											<input type=button class="btn btn-primary navbar-btn"
												role="button" value="Ajouter une image">
										</div>
									</div>
								</aside>
								<aside class="row">
									<div class="panel panel-default" id="descriptionDetail">
										<div class="panel-heading">Description</div>
										<div class="panel-body" id="descriptionDetail_text">
											<s:property value="description_f" />
										</div>
									</div>
									<div id="modif_description">
									<button onclick="description_modifie()">Visualiser les modifications</button>
									<p id="result" style="color: grey;"></p>
									</div>
								</aside>
							</div>
							<div class="col-md-4">
								<aside id="video" class="col-lg-12">
								<h4>Regarder la vidéo de l'objet :</h4>
								<iframe width="400" height="225"
									src="https://www.youtube.com/embed/LqTyPFFS8fg" frameborder="0"
									allowfullscreen></iframe> </aside>

								<aside id="video" class="videoDetail col-lg-12">
								<h4>Regarder la vidéo de l'objet :</h4>

								<iframe width="400" height="225"
									src="https://www.youtube.com/embed/LqTyPFFS8fg" frameborder="0"
									allowfullscreen></iframe> </aside>

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
				</s:if>


					<div class="row">
						<div class="col-lg-5 col-lg-offset-1">

							<s:iterator value="listCommentAndNameUser">
								<s:if test="show==0">
									<div class="media">
										<div class="media-body">
											<h4 class="media-heading">
												<s:property value="pseudo" />
												<s:property value="show" />
												<small><s:date name="date" format="dd/MM/yyyy" /> �
													<s:date name="date" format="hh:mm:ss" /></small>
											</h4>
											<s:property value="text" />
										</div>
									</div>
								</s:if> 
							</s:iterator>
						</div>
					</div>
				
			</div>
			<div class="col-lg-1"></div>
		</div>


		<div class="row">
			<s:include value="footer.jsp"></s:include>
		</div>
	</div>
	<script src="js/enrichissement.js"></script>
</body>
</html>