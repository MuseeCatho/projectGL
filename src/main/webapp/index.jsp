<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  
  <style type="text/css">
    #container{position:relative;width:100%;margin:auto;}
    .carousel-inner{
        height: 500px;
    }
    #pres{
        margin-top: 100px;
        width:90%;
    }.panel-footer{
        margin-top: 50px;
    }body{
        background-color: #EFEFC8;
    }
  </style>
  <body>
    <div id="container">
<s:include value="header.jsp"></s:include>

        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
              </ol>

              <!-- Wrapper for slides -->
              <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="img/carousel1.jpg" alt="caroussel1">
                  <div class="carousel-caption">
                    Image1
                  </div>
                </div>
                <div class="item">
                  <img src="img/carousel2.jpg" alt="carousel2">
                  <div class="carousel-caption">
                    Image2
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
       



        <div class="row top-buffer" id="pres">
            <div class="col-lg-4 col-lg-offset-1"><img src="img/presentation.jpg" class="img-responsive" alt="Responsive image"></div>


            <div class="col-lg-4 col-lg-offset-1">Texte de présentation</div>
            

        </div>
        
        <s:include value="footer.jsp"></s:include>
        
       </div>
  </body>
</html>