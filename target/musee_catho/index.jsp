<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script src="http://code.jquery.com/jquery.js"></script>
            <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        

    <title>Maquette musée</title>
  </head>
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


            <nav class="navbar navbar-default">
              <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#">Brand</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">Accueil<span class="sr-only">(current)</span></a></li>
                    <li><a href="oeuvres.jsp">Oeuvres</a></li>
                    <li><a href="carte.jsp">Carte</a></li>
                    <li><a href="#">Contacts</a></li>
                    <!--<li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                      </ul>
                    </li>-->
                  </ul>
                  <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="Mot-clef">
                    </div>
                    <button type="submit" class="btn btn-default">Rechercher</button>
                  </form>


                   <form class="navbar-form navbar-right" role="search">
                    <div class="btn-group">
                          <button type="button" class="btn btn-danger">Langues</button>
                          <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                          </button>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Francais</a></li>
                            <li><a href="#">Anglais</a></li>
                          </ul>
                    </div>
                  </form>


                   <button type="button" class="btn btn-primary navbar-btn">Login</button>
                    

                </div><!-- /.navbar-collapse -->
              </div><!-- /.container-fluid -->
            </nav>



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



        </div>

        <div class="row top-buffer" id="pres">
            <div class="col-lg-4 col-lg-offset-1"><img src="img/presentation.jpg" class="img-responsive" alt="Responsive image"></div>


            <div class="col-lg-4 col-lg-offset-1">Texte de présentation</div>
            

        </div>

        <div class="panel-footer" id="footer">
 
        <p class="text-center">&copy; Company | Privacy | Terms</p>
 
      </div>
 
    <!-- Include Javascript -->
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">

</script>
  </body>
</html>