<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.js"></script>
<script src="js/comment.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/mediaCarousel.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Oeuvre</title>
</head>
<body>

	<div id="container">
		<s:include value="header.jsp"></s:include>

		<div class="row" style="width: 80%; margin: auto;">

			<s:iterator value="listDetailPage">

				<div id="header-object" style="margin-top: -40px;">
					<div style="flaot: left; display: inline-block;">
						<h1
							style="color: #222; font-size: 1.28em; padding: 18px 0 5px 0; line-height: 1.2em; font-weight: bold;">
							Oeuvre <span
								style="display: block; font-size: 1.3em; padding: 2px 0 0 0; color: #A66F4D;"><s:property value="title_f" /></span>
						</h1>
					</div>
					<div style="display: inline-block; float: right; margin-top: 35px;">
						<a class="btn btn-primary navbar-btn" href="#" role="button"
							style="">Proposer une modification</a>
					</div>
				</div>
				<!--<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
				<!-- <ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					</ol>

					<!-- Wrapper for slides -->
				<!--	<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="img/jerusalem-22.jpg" alt="caroussel1">
							<div class="carousel-caption">Image1</div>
						</div>

					</div>

					<!-- Controls -->
				<!--	<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>-->
			
				
				<s:include value="mediaCarousel.jsp">
					<s:param name="mediaType">image</s:param>					
					<s:param name="mediaNames"><s:property value="link_photos"/></s:param>
				</s:include>
				
				
				
				
				<div id="object" style="background-color: white;">

					<div style="display: block;">
						<div class="panel panel-default"
							style="width: 50%; margin-top: 15px; display: inline-block; float: left;">
							<div class="panel-heading">Description</div>
							<div class="panel-body"><s:property value="description_f" /></div>
						</div>

						<div
							style="display: inline-block; margin-top: 15px; text-align: center; border: 1px solid grey; border-radius: 2px; width: 300px; height: 300px; margin-left: 50px;">
							<h1 style="text-align: center;">Image 3d</h1>
						</div>
					</div>

					<div id="video" style="clear: both;">
						<h4>Regarder la vidéo de l'objet :</h4>
						<iframe width="400" height="225"
							src="https://www.youtube.com/embed/LqTyPFFS8fg" frameborder="0"
							allowfullscreen></iframe>
					</div>

					

				</div>
			</s:iterator>
		</div>
		<div class="row">
		</div>
		<s:if test="%{#session.firstname!=null}">
		<div class="row top-buffer">
			<div class="col-lg-5 col-lg-offset-1">
				<form>
				<div class="form-group">
						<label for="commentObject">Comment:</label>
						 <textarea class="form-control" rows="3" id="commentObject"></textarea>
				</div>
					<button type="button" class="btn btn-default" onclick="addComment(<s:property value="#session.id_user"/>);">Submit</button>
				</form>
			</div>
		</div></br>
		<div class="row">
			<div class="col-lg-5 col-lg-offset-1">
			<s:iterator value="commentDetail">
		              <div class="panel panel-primary">
		                <div class="panel-heading">
		                    <h3 class="panel-title"><s:property value="pseudo"/></h3>
		                  </div>
		                  <div class="panel-body">
		                    <div class="col-lg-2"><s:property value="text"/><br/></div>
		                  </div>
		              </div>
			</s:iterator>
			</div>
		</div>
		</s:if>
		



		<s:include value="footer.jsp"></s:include>

	</div>
</body>
</html>