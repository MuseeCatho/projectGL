<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<s:include value="import.jsp"></s:include>
	
	<title>Museum</title>
</head>

<body>
<s:include value="header.jsp"></s:include>
	<!-- <img id="background" src="img/un-peu-de-prehistoire.jpg"/> -->

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
						<img src="img/carousel1.jpg" alt="caroussel1" class="img-responsive">
						<div class="carousel-caption">Image1</div>
					</div>
					<div class="item">
						<img src="img/carousel2.jpg" alt="carousel2" class="img-responsive">
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

					 					 
					<%--  <s:text name="global.language" /> --%>
					<s:if test="#global.language=='en'">
						anglais
					</s:if>
					<s:if test="%{global.language=='fr'}">
						francais 
					</s:if>				
			
		<section>		
			<div id="blockCategory">
	
				<s:iterator value="listCategory">
					<div class="col-sm-2 col-xs-4 col-xs-offset-1 col-sm-offset-1">
						<img class="img-circle" src="<s:property value="link_category"/>"
							width="140" height="140">
						<h2>
							<s:property value="name_f" />
						</h2>
					</div>
					<!-- /.col-lg-4 -->
				</s:iterator>
			</div>
		</section>


		<div class="row"></div>
		<!-- /.row -->
		<div class="hero">
			
			<div class="row">
	                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
	                    <hr class="section-heading-spacer">
	               
	                    <h2 class="section-heading">Musée catholique</h2>
	                    <p class="lead">Ceci est le texte de présentation du musée catho</p>
	                </div>
	                <div class="col-lg-4 col-sm-pull-5  col-sm-5">
	                   
	                    <img class="img-responsive" src="<s:property value="linkPhoto"/>" class="img-responsive" alt="">
	                </div>
	        </div>
        </div>
		
		


		<s:include value="footer.jsp"></s:include>

</body>
</html>