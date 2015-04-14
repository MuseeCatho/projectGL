<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Objet n°1</title>
</head>
<body>

<div id="container">


            <s:include value="header.jsp"></s:include>

       <div class="row" style="width:80%;margin:auto;">
       

			
       		<div id="header-object" style="margin-top:-40px;">
       		<div style="flaot:left;display:inline-block;">
				<h1 style=" color: #222;font-size: 1.28em; padding: 18px 0 5px 0;line-height: 1.2em;font-weight: bold;">Oeuvre
	  			<span style="  display: block;font-size: 1.3em;padding: 2px 0 0 0;  color: #A66F4D;">Bas relief Hébraique</span>
	  			</h1>
	  			</div>
	  			<div style="display:inline-block;float:right;margin-top:35px;">
			<a class="btn btn-primary navbar-btn" href="#" role="button" style="">Proposer une modification</a>
			</div>
			</div>
			
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
              </ol>

              <!-- Wrapper for slides -->
              <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="img/jerusalem-22.jpg" alt="caroussel1">
                  <div class="carousel-caption">
                    Image1
                  </div>
                </div>
           
              </div>

              <!-- Controls -->
              <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
            
            
            <div id="object" style="background-color:white;">
		    
		        <div style="display:block;">
		     <div class="panel panel-default" style="width:50%;margin-top:15px;display:inline-block;float:left;">
  <div class="panel-heading">Description</div>
  <div class="panel-body">
  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo co
  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo co
  </div>
</div>

<div style="display:inline-block; margin-top:15px;  text-align: center;
  border: 1px solid grey;
  border-radius:2px;
  width: 300px;
  height: 300px;margin-left:50px;">
<h1 style="text-align:center;">Image 3d</h1>
</div>
</div>

<div id="video" style="clear:both;">
<h4>Regarder la vidéo de l'objet :</h4>
<iframe width="400" height="225" src="https://www.youtube.com/embed/LqTyPFFS8fg" frameborder="0" allowfullscreen></iframe>
</div>

<div style="margin-top:30px;">
<h4>Ajouter un commentaire :</h4>
<textarea style="margin: 0px; height: 150px; width: 420px;">

</textarea>
</div>
	        
	        </div>
        
        </div>
        
 
        
        <s:include value="footer.jsp"></s:include>
        
   </div>

</body>
</html>