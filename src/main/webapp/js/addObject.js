function AddObjectAdmin(){
	
	var title_f = $( "#title_f" ).val(); 
	var description_f = $( "#description_f" ).val(); 
	var reference = $("#reference").val();
	var country = $("#country").val();
	var city = $("#city").val();
	console.log("console:"+title_f+" "+description_f);
	$.ajax({
	       url : 'admin/add_object_test.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data: {
//	    	   "title_f": title_f,
//	    	   "description_f": description_f,
//	    	   "reference":reference,
//	    	   "country":country,
//	    	   "city":city
	    	},
	       success : function(data){
	    	   console.log(data);
	    	   window.location = 'http://localhost:8080/musee_catho/admin/index.jsp';
	    	   alert("ok");
	    	
	       }
	    });
}
