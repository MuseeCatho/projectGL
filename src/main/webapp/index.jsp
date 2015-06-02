<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<s:include value="import.jsp"></s:include>
	<link rel="stylesheet" href="css/main.css">
	<title>Museum</title>
</head>

<body>
	<!-- <img id="background" src="img/un-peu-de-prehistoire.jpg"/> -->
	<div id="container">
		<s:include value="header.jsp"></s:include>

		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="img/carousel1.jpg" alt="caroussel1">
					<div class="carousel-caption">Image1</div>
				</div>
				<div class="item">
					<img src="img/carousel2.jpg" alt="carousel2">
					<div class="carousel-caption">Image2</div>
				</div>
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		
<%-- 	<s:property value="request_locale" />
					<s:if test="%{param.request_locale=='fr'}">
						francais 
					</s:if>
					<s:else>
						anglais
					</s:else> 
					<s:if test="%{#global.map=='Map'}">
						francais 
					</s:if>
					<s:else>
						anglais
					</s:else> 
					 --%>
					
		<div id="blockCategory">

			<s:iterator value="listCategory">
				<div class="col-lg-2 col-lg-offset-1">
					<img class="img-circle" src="<s:property value="link_category"/>"
						width="140" height="140">
					<h2>
						<s:property value="name_f" />
					</h2>
				</div>
				<!-- /.col-lg-4 -->
			</s:iterator>

		</div>


		<div class="row"></div>
		<!-- /.row -->
		<div class="row top-buffer" id="pres">
			<div class="col-lg-4 col-lg-offset-1">
				<img src="img/presentation.jpg" class="img-responsive"
					alt="Responsive image">
			</div>
			<div class="col-lg-4 col-lg-offset-1">Texte de présentation</div>
		</div>







		<s:include value="footer.jsp"></s:include>

	</div>
</body>
</html>