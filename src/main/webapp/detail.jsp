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
<title> Detail Oeuvre</title>
</head>
<body id="bodyDetail">
	<div id="container">
		<s:include value="header.jsp"></s:include>
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10" id="header">
			<br><br><br>
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
											<s:iterator value="listDetail" status="listD">
												<s:if test="showI == false">
													<div id="photoDetail"
														class="photoDetail col-xs-4 col-sm-3 col-md-2 ">
														<img border-color="blue" id="listPhotosImg"
															src="<s:property value="link_photos"/>"
															alt="Responsive image"> <a class="cursor_ok"
															onclick="cancelProposition('image',<s:property value="id"/>)">
															<img alt="alternativtext" class="icon icon_ok"
															" src="img/icon/ok.png"
															id="icon_ok_image<s:property value="id"/>" width="30"
															height="30">
														</a> <a class="cursor_delete"
															onclick="addProposition('image', <s:property value="id"/>,'delete')">
															<img alt="alternativtext" class="icon icon_cancel"
															src="img/icon/cancel.png"
															id="icon_cancel_image<s:property value="id"/>" width="30"
															height="30">
														</a>
													</div>
												</s:if>
											</s:iterator>
										</div>
									</div>
									<div class="row">
										<div class="col-md-8"></div>
										<div id="ajoutMedia" class="col-md-4">
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
								<aside id="carouselVideo" class="col-lg-12">
								<h4>Regarder les vidéos:</h4>
								<s:include value="mediaCarousel.jsp">
									<s:param name="mediaType">video</s:param>
									<s:param name="mediaNames">
										<s:property value="link_video" />
									</s:param>
									<s:param name="mediaCarouselId">mediaCarousel2</s:param>
								</s:include> </aside>
								<aside id="listVideo">
								<div class="tablecell" class="row">
									<s:iterator value="listDetailVideo" status="listV">
										<s:if test="showI == false">
											<div id="photoDetail"
												class="videoDetail col-xs-4 col-sm-3 col-md-2 ">
												<video id="video" class="video vjs-default-skin" controls
													preload="none" data-setup='{"example_option":true}'form
													
													width="100%" height="100%"> <source
													src="<s:property value="link_video"/>" type='video/mp4' />

												</video>

												<a class="cursor_ok"
													onclick="cancelProposition('video',<s:property value="id"/>)">
													<img alt="alternativtext" class="icon icon_ok"
													" src="img/icon/ok.png"
													id="icon_ok_video<s:property value="id"/>" width="30"
													height="30">
												</a> <a class="cursor_delete"
													onclick="addProposition('video', <s:property value="id"/>,'delete')">
													<img alt="alternativtext" class="icon icon_cancel"
													src="img/icon/cancel.png"
													id="icon_cancel_video<s:property value="id"/>" width="30"
													height="30">
												</a>
											</div>
										</s:if>
									</s:iterator>
								</div>

								<div class="row">
									<div class="col-md-8"></div>
									<div id="ajoutVideo" class="col-md-4">
										<form method="post" id="formVideo" action="addVideo.action">
											<input accept="accept="
												video/mp4,video/x-m4v,video/*""
											type="file"
												id="fileVideo" class="btn btn-primary navbar-btn"
												value="Ajouter une vidéo" id="fileInput" name="upload" /> <input
												type="url" />
												<input type="submit" value="Envoyer" />
										</form>
									</div>
									<div class="tablecell col-md-12" id="prev"></div>
								</div>
								</aside>
							</div>

							<aside id="audio" class="audioDetail col-lg-12">
							<h4>Ecouter les audios:</h4>
							<s:include value="mediaCarousel.jsp">
								<s:param name="mediaType">audio</s:param>
								<s:param name="mediaNames">
									<s:property value="link_video" />
								</s:param>
								<s:param name="mediaCarouselId">mediaCarousel3</s:param>
							</s:include> </aside>

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
				
			<br>
			<br>
			<div class="row">
			<div class="col-lg-5 col-lg-offset-1">
				<h2>Comments</h2>	
			</div>
			</div>
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
					
			<div class="col-lg-5 col-lg-offset-1">


					<s:iterator value="listCommentAndNameUser">
						<s:if test="show==1">
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
						</s:if>
					</s:iterator>
				</div>		
					
					
					
					
			</div>
			</s:iterator>
			<hr>
			


			<div class="row">
				
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