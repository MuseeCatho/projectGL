<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>
<script src="js/comment.js"></script>
<s:include value="import.jsp"></s:include>
<link rel="stylesheet" href="css/mediaCarousel_old.css">
<link rel="stylesheet" href="css/detail.css">
<s:include value="mediaElementsRequired.jsp"></s:include>
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
						<s:if test="%{#session.firstname!=null}">
							<div class=col-sm-2>
								<div>
									<div class="modification">
										<input type=button
											class="btn btn-primary navbar-btn bouttonModification"
											role="button" value="Proposer une modification"
											id="buttonChange"
											onClick="hideEnr(<s:property value="#session.id_user"/>);">
									</div>
									<div id="annulationProposition" class="modification">
										<input type=button
											class="btn btn-primary navbar-btn bouttonModification"
											role="button" value="Annuler" onClick="annulation();">
									</div>
								</div>
							</div>
						</s:if>

						<div>
							<div class="col-md-8">
								<div class="row">
									<div id="carouselPhotos">
										<s:include value="mediaCarousel.jsp">
											<s:param name="mediaType">image</s:param>
											<s:param name="mediaNames">
												<s:property value="link_photos" />
											</s:param>
											<s:param name="height">400px</s:param>
										</s:include>
									</div>
								</div>
								<div id="listPhotos" class="row">
									<div>
										<div class="tablecell" class="row">
											<s:iterator value="listDetail">
												<div id="photoDetail"
													class="photoDetail col-xs-4 col-sm-3 col-md-2 ">
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
									</div>
									<div class="row">
										<div class="col-md-8"></div>
										<div id="ajoutImage" class="col-md-4">
											<input type=button class="btn btn-primary navbar-btn"
												role="file" value="Ajouter une image"
												onclick="$('#file').click();"> <input
												style="display: none" type="file" id="file"
												class="btn btn-primary navbar-btn" value="Ajouter une image"
												id="fileInput" name="upload" />
										</div>
										<div class="tablecell col-md-12" id="prev"></div>
									</div>
								</div>
								<div class="row"></div>
								<div class="panel panel-default" id="descriptionDetail">
									<div class="panel-heading">Description</div>
									<div class="panel-body" id="descriptionDetail_text">
										<s:property value="description_f" />
									</div>
								</div>
								<div id="modif_description">
									<button type="button" class="btn btn-primary btn-lg"
										data-toggle="modal" data-target="#myModal"
										onclick="description_modifie()">Visualiser les
										modifications</button>
									<div class="modal fade" id="myModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Visualisation</h4>
												</div>
												<div class="modal-body">
													<p id="result" style="color: grey;"></p>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Revenir</button>
													<button type="button" class="btn btn-primary"
														id="save_modif_descr" onclick="saveModifDescr()">Enrengistrer
														les modifications</button>
												</div>
											</div>
										</div>
									</div>

								</div>

							</div>
							<div class="col-md-4">
								<aside id="video" class="col-lg-12">
								<h4>Regarder la vidéo:</h4>
								<s:include value="mediaCarousel.jsp">
									<s:param name="mediaType">video</s:param>
									<s:param name="mediaNames">http://video-js.zencoder.com/oceans-clip.mp4</s:param>
									<s:param name="mediaCarouselId">mediaCarousel2</s:param>
								</s:include></aside>

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
							<s:if test="show==1">
								<div class="media">
									<div class="media-body">
										<h4 class="media-heading">
											<s:property value="pseudo" />
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