var geocoder;
var latitude;
var longitude;

function AddObjectAdmin(){
	//alert("ok");
	var title_f = $( "#title_f" ).val(); 
	var description_f = $( "#description_f" ).val(); 
	var reference = $("#reference").val();
	var country = $("#country").val();
	var city = $("#city").val();
	console.log("console:"+title_f+" "+description_f);
	var latitude;
	var longitude;
	//alert("ok");
	console.log("country:"+country);
	console.log("city:"+city);
	getLatitudeLongitude((country+","+city), function(num) {
	    // this anonymous function will run when the
	    // callback is called
		latitude=num.lat();
		longitude=num.lng();
		
		//alert(longitude);
		//alert(latitude);
		document.getElementById("longitude").value=longitude;
		document.getElementById("latitude").value=latitude;
		//alert(document.getElementById("latitude").value);
		var datas={ "title_f": title_f,
		    	   "description_f": description_f,
		    	   "reference":reference,
		    	   "country":country,
		    	   "city":city,
		    	   "latitude": latitude,
		    	   "longitude" : longitude,
		    	   "period": $('#period').val(),
		    	   "categories": []
				
		};
		   $("input:checked").each(function() {
	 	          datas['categories'].push($(this).val());
	 	       });
		   datas['categories']=datas['categories'].join(",")
	$.ajax({
	       url : 'admin/add_object.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data: datas,
    	
	       success : function(data){
	    	   console.log(data);
	    	   window.location = 'http://localhost:8080/musee_catho/admin/index.jsp';
	    	   //alert("ok");
	    	
	       }
	    });
	
	});
	alert("Objet ajouté ");
	//alert("ok");
	//console.log("list[0]:"+list[0]);
	//console.log(codeAddress(country+","+city));
//	document.getElementById("longitude").value=list[0];
//	document.getElementById("latitude").value=list[1];

}

function getLatitudeLongitude(address,callback) {
	console.log("getLatitudeLongitude adress"+address);
	    var geocoder= new google.maps.Geocoder();
	    geocoder.geocode( { 'address': address}, function(results, status) {
	    	console.log("status  : "+status);
	      if (status == google.maps.GeocoderStatus.OK) {
	    	  callback(results[0].geometry.location);
	    	  console.log("location.lat : "+results[0].geometry.location.lat());
	    	  console.log("location.lng : "+results[0].geometry.location.lng());
	    	  //alert([results[0].geometry.location.lat(),results[0].geometry.location.lng()]);
	    	  //window.long=[results[0].geometry.location.lat(),results[0].geometry.location.lng()];
	    	  //window.lat=[results[0].geometry.location.lat(),results[0].geometry.location.lat()];
	    	  //alert("lat:"+lat);
	  		document.getElementById("longitude").value=results[0].geometry.location.lat();
    		document.getElementById("latitude").value=results[0].geometry.location.lng();
	      } else {

	        alert('Geocode was not successful for the following reason: ' + status);
	      }
	    });
	  
}
//
//function codeAddress(address) {
//
//	  var geocoder = new google.maps.Geocoder();
//	  geocoder.geocode( { 'address': address}, function(results, status) {
//      if (status == google.maps.GeocoderStatus.OK) {
//	
//				document.getElementById('latitude').value = results[0].geometry.location.lat();
//				document.getElementById('longitude').value = results[0].geometry.location.lng();
//
//				//return[results[0].geometry.location.lat(),results[0].geometry.location.lng()];
//      } else {
//        alert("Le geocodage n\'a pu etre effectue pour la raison suivante: " + status);
//      }
//    });
//  }



