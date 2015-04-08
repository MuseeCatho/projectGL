<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <style type="text/css">
    #container{position:relative;width:100%;margin:auto;}
    #map{width:1000px;height:550px;margin:auto;}
  </style>
  <body>
    <div id="container">


            <s:include value="header.jsp"></s:include>

       <div id="map">
            <p>Veuillez patienter pendant le chargement de la carte...</p>
        </div>
        
        
        <s:include value="footer.jsp"></s:include>
        
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
 
  
  
  getPosition(map);
  
	    
	    
};
initialize();

function getPosition(map){
	
	
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
	    	   //console.log(data);
	    	   alert(data);
	    	   var res = data.replace(/&quot;/g, "\"");
	    	   console.log(res);
	    	   console.log("res.length: "+res.length);
	    	   var jsoParse=JSON.parse(res);
/* 	    	   console.log("jsoParse[0].id : "+jsoParse[0].id);
	    	   console.log("jsoParse[0].id : "+jsoParse[0].title);
	    	   console.log("jsoParse[0].id : "+jsoParse[0].id); */
	    	   console.log("jsoParse.length : "+jsoParse.length);
	    	   
	    	   for (var i = 0; i < jsoParse.length; i++) {
	    		    console.log("country : "+jsoParse[i].country);
	    		    console.log("city : "+jsoParse[i].city);
	    		    var adress=jsoParse[i].country+" , "+jsoParse[i].city;
	    		    codeAddress(map,adress);
	    	   }

	    	   
	       }
	    });
	
}



function codeAddress(map,address) {
   // var address = 'Sydney, NSW';
    var geocoder= new google.maps.Geocoder();
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
}


</script>
  </body>
</html>