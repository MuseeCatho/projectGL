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

        

    <title>Google Maps Api v3</title>
  </head>
  <style type="text/css">
    #container{position:relative;width:100%;margin:auto;}
    #map{width:1000px;height:550px;margin:auto;}
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



       <div id="map">
            <p>Veuillez patienter pendant le chargement de la carte...</p>
        </div>
 
    <!-- Include Javascript -->
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">
    var map;
var initialize;
 
initialize = function(){

    var mapOptions = {
        zoom: 2,
        center: new google.maps.LatLng(48,2),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        disableDefaultUI: true
    }
    var map = new google.maps.Map(document.getElementById('map'), mapOptions);

    var myLatLng = new google.maps.LatLng(48.583148,7.747882);
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Strasbourg'
    });

    var myLatLng2 = new google.maps.LatLng(47.218371,-1.553621);
    var marker2 = new google.maps.Marker({
        position: myLatLng2,
        map: map,
        title: 'Nantes'
    });

    var myLatLng3 = new google.maps.LatLng(48.218371,-1.553621);
    var marker3 = new google.maps.Marker({
        position: myLatLng3,
        map: map,
        title: 'Rennes'
    });

    var myLatLng4 = new google.maps.LatLng(49.4308412,1.0706169);
    var marker4 = new google.maps.Marker({
        position: myLatLng4,
        map: map,
        title: 'Rennes'
    });

    var myLatLng5 = new google.maps.LatLng(24.4308412,1.0706169);
    var marker5 = new google.maps.Marker({
        position: myLatLng5,
        map: map,
        title: 'Afrique'
    });

    var myLatLng5 = new google.maps.LatLng(50.4308412,50.0706169);
    var marker5 = new google.maps.Marker({
        position: myLatLng5,
        map: map,
        title: 'Asie'
    });

    var myLatLng5 = new google.maps.LatLng(50.4308412,80.0706169);
    var marker5 = new google.maps.Marker({
        position: myLatLng5,
        map: map,
        title: 'Asie'
    });

    var myLatLng5 = new google.maps.LatLng(-30.4308412,140.0706169);
    var marker5 = new google.maps.Marker({
        position: myLatLng5,
        map: map,
        title: 'Oceanie'
    });
    var myLatLng4 = new google.maps.LatLng(49.4308412,-122.0706169);
    var marker4 = new google.maps.Marker({
        position: myLatLng4,
        map: map,
        title: 'States'
    });

    var myLatLng4 = new google.maps.LatLng(-30.4308412,-62.0706169);
    var marker4 = new google.maps.Marker({
        position: myLatLng4,
        map: map,
        title: 'States'
    });



    var contentString = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">Livre biblique</h1>'+
      '<div id="bodyContent">'+
      '<p>descriptionss</p>'+
      '</div>'+
      '</div>';

  var infowindow = new google.maps.InfoWindow({
      content: contentString
  });

  google.maps.event.addListener(marker2, 'click', function() {
    infowindow.open(map,marker2);
  });

    
};
initialize();

function getPosition(){
	
	
	$.ajax({
	       url : 'getLocationForMap.action',
	       type : 'POST',
	       contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
/* 	       data     : {
	    	   "login": $("#login").val(),
	    	   "password": $("#password").val()
	    	}, */
	       success : function(data){
	    	   console.log(data);
	    	  alert("test");
	       }
	    });
	
}
getPosition();
</script>
  </body>
</html>