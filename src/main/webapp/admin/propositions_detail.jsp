<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
<s:include value="import.jsp"></s:include>
<link rel="stylesheet" href="css/detailAdmin.css">
</head>
<body>
	<s:if test="%{#session.id_userAdmin!=null}">

		<s:include value="header_admin.jsp"></s:include>
		<jsp:include page="navigation.jsp">
			<jsp:param name="pageName" value="propositions_manager" />
		</jsp:include>

		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">Gestion des propositions de modification</h1>
			<body id="bodyDetail">
				<div id="container">
					<div class="row">
						<div class="col-lg-10" id="header">
							<br> <br> <br>
							<s:iterator value="listDetailPageAdmin">

								<div class="row" id="header-object">
									<div class="col-sm-10">
										<h1>
											Oeuvre <span id="titleDetail"><s:property
													value="title_f" /></span>
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
									<div class="col-md-8">
										<div id="listPhotosAdmin" class="row">
											<div>
												<div class="tablecell" class="row">
													<s:iterator value="listDetailAdmin" status="listD">
														<s:if test="showI == false">
															<div id="propositionImage">
																<div id="photoDetailAdmin"
																	class="photoDetail col-xs-4 col-sm-3 col-md-2 image<s:property value="id"/>">
																	<img border-color="blue" id="listPhotosImg"
																		src="../<s:property value="link_photos"/>"
																		alt="Responsive image"> </a> <a
																		class="cursor_delete"
																		onclick="addProposition('image', <s:property value="id"/>,'delete')">
																		<img alt="alternativtext" class="icon icon_cancel"
																		src="../img/icon/cancel.png"
																		id="icon_cancel_image<s:property value="id"/>"
																		width="30" height="30">
																	</a>
																</div>
																<div id="ajoutMediaAdmin">
																	<input type=button class="btn btn-primary navbar-btn"
																		role="file" value="Accepter la proposition"
																		onclick="$('#file').click();">
																</div>
															</div>
														</s:if>
													</s:iterator>
												</div>
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
										</aside>
										<aside id="listVideo">
											<div class="row">
												<s:iterator value="listDetailAdminVideo">
													<div id="photoDetail" class="videoDetail col-xs-4  ">
														<video id="video" class="video vjs-default-skin" controls
															preload="none" data-setup='{"example_option":true}' form
															width="100%" height="100%">
															<source src="<s:property value="link_video"/>"
																type='video/mp4' />

														</video>


														</a> <a class="cursor_delete"
															onclick="addProposition('video', <s:property value="id"/>,'delete')">
															<img alt="alternativtext" class="icon icon_cancel"
															src="img/icon/cancel.png"
															id="icon_cancel_video<s:property value="id"/>" width="30"
															height="30">
														</a>
													</div>
												</s:iterator>
											</div>
										</aside>
									</div>
									</br>

							<div class="col-md-8"></div>
									<div class="col-md-4">
										<aside id="carouselAudio" class="col-lg-12">
											<h4>Ecouter les audios:</h4>
										</aside>
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
						<div class="col-sm-2">
							<s:iterator value="listObjectEnrichment">
								<div class="media">
									<div class="media-body">
										<h4 class="media-heading">
											<div id="listPro">

												<s:iterator value="listUserId">
													Par:
													<s:property value="pseudo" />
													<small><s:date name="date" format="dd/MM/yyyy" /></small>
												</s:iterator>
												<img id="buttonAdmin"
													src="img/bouton-aide-perspective--icone-6877-96.png"
													<s:if test="admin==1">
								title="Administrer" alt="Administrer"
							</s:if>
													<s:else>
								title="Administrer" alt="Administrer"
							</s:else>
													onclick="getListProposition(<s:property value="id" />)" />
											</div>
										</h4>
									</div>
								</div>

							</s:iterator>
						</div>
						<hr>
						<s:if test="%{#session.id_userAdmin!=null}">
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
													<small><s:date name="date" format="dd/MM/yyyy" />
														� <s:date name="date" format="hh:mm:ss" /></small>
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


				<div class="row"></div>
		</div>
		</div>


	</s:if>

	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>
	</s:else>
</body>

<script src="js/detailEnrichment.js"></script>
</html>