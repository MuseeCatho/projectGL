var geocoder;
var latitude;
var longitude;
var long="000", lat="000";
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
	alert("ok");
	var list=[];
	list=getLatitudeLongitude(country+","+city, function(num) {
	    // this anonymous function will run when the
	    // callback is called
		latitude=num.lat();
		longitude=num.lng();
		
//		alert(longitude);
//		alert(latitude);
//		document.getElementById("longitude").value=longitude;
//		document.getElementById("latitude").value=latitude;
		//alert(document.getElementById("latitude").value);
//	$.ajax({
//	       url : 'admin/add_object.action',
//	       type : 'POST',
//	       //contentType: "application/json",
//	       encoding:"UTF-8",
//	       async: true,
//	       data: {
//	    	   "title_f": title_f,
//	    	   "description_f": description_f,
//	    	   "reference":reference,
//	    	   "country":country,
//	    	   "city":city,
//	    	   "latitude": latitude,
//	    	   "longitude" : longitude
//
//	    	},
//	       success : function(data){
//	    	   console.log(data);
//	    	   window.location = 'http://localhost:8080/musee_catho/admin/index.jsp';
//	    	   alert("ok");
//	    	
//	       }
//	    });
	
	});
	alert("ok");
	alert(long);
	
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
	    	  alert([results[0].geometry.location.lat(),results[0].geometry.location.lng()]);
	    	  window.long=[results[0].geometry.location.lat(),results[0].geometry.location.lng()];
	    	  window.lat=[results[0].geometry.location.lat(),results[0].geometry.location.lat()];
	    	  alert("lat:"+lat);
	  		window.document.getElementById("longitude").value=results[0].geometry.location.lat();
    		window.document.getElementById("latitude").value=results[0].geometry.location.lng();
	    	  return [results[0].geometry.location.lat(),results[0].geometry.location.lng()];
	      } else {

	        alert('Geocode was not successful for the following reason: ' + status);
	      }
	    });
	  
}



