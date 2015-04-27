function addUser(){
	
	alert("adduser");
	var name = $( "#name" ).val(); 
	var firstname = $( "#firstname" ).val(); 
	var pseudo = $("#pseudo").val();
	var email = $("#email").val();
	var password = $("#password").val();
	var country = $("#country").val();
	var city = $("#city").val();
	var job = $("#job").val();
	alert("name : "+name + "____ pseudo :"+pseudo);
	if(name=="" || firstname=="" || pseudo=="" || email=="" || password=="" || country=="" || city==""){
		alert("Tous les champs ne sont pas remplis");
	}else{

		
	$.ajax({
	       url : 'add_user.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data: {
	    	   "name": name,
	    	   "firstname": firstname,
	    	   "pseudo":pseudo,
	    	   "email":email,
	    	   "password":password,
	    	   "country": country,
	    	   "city" : city,
	    	   "job" : job
	    	},
	       success : function(data){
	    	   window.location = 'http://localhost:8080/musee_catho/index.jsp';
	    	   alert("Vous êtes désormais inscrit");
	       }
	    });
	}

}