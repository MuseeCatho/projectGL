var map;
var initialize;
var listMarker=[];
 
initialize = function(){

    var mapOptions = {
        zoom: 2,
        center: new google.maps.LatLng(48,2),
        mapTypeControl: true,
        mapTypeControlOptions: {
          style: google.maps.MapTypeControlStyle.DEFAULT,
          mapTypeIds: [
            google.maps.MapTypeId.ROADMAP,
            google.maps.MapTypeId.TERRAIN
          ]
        },
        zoomControl: true,
        zoomControlOptions: {
          style: google.maps.ZoomControlStyle.SMALL
        }
    }
    var map = new google.maps.Map(document.getElementById('map'), mapOptions);
  
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
	       success : function(data){
	    	   //console.log(data);
	    	   var res = data.replace(/&quot;/g, "\"");
	    	   console.log(res);
	    	   console.log("res.length: "+res.length);
	    	   var jsoParse=JSON.parse(res);
	    	   console.log("jsoParse.length : "+jsoParse.length);

	    	   for (var i = 0; i < jsoParse.length; i++) {
	    		    console.log("country : "+jsoParse[i].country);
	    		    console.log("city : "+jsoParse[i].city);
	    		    //var adress=jsoParse[i].country+" , "+jsoParse[i].city;
	    		    var latitude=jsoParse[i].latitude; 
	    		    var longitude=jsoParse[i].longitude; 
	    		    var myLatlng = new google.maps.LatLng(latitude,longitude);
	    		    
	    		    listMarker[i]=createMarker(myLatlng,"m"+i,map,jsoParse[i].title_f,jsoParse[i].description_f,jsoParse[i].id);
	    	   }
	       }
	    });

	
}

function createMarker(pos, t,map,title,description,id) {
    var marker = new google.maps.Marker({       
        position: pos, 
        map: map,  // google.maps.Map 
        title: t      
    }); 
    

    var contentString = '<a href="detailObject.action?id='+id+'"><div id="content" class="myInfoWindow">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">'+title+'</h1>'+
      '<div id="bodyContent">'+
      '<p>'+description+'</p>'+
      '</div>'+
      '</div>';

  var infowindow = new google.maps.InfoWindow({
      content: contentString
  });
  
    google.maps.event.addListener(marker, 'click', function() { 
    	infowindow.open(map,marker); 
    }); 
    return marker;  
}