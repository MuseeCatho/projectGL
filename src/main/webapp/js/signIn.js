function signInAdmin(){
	var pseudo = $( "#inputEmail" ).val(); 
	var password = $( "#inputPassword" ).val(); 
	console.log(password+" -- "+pseudo);
	
	
	$.ajax({
	       url : 'sign.action?admin=1',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data     : {
	    	   "pseudo": pseudo,
	    	   "password": password
	    	},
	       success : function(data){
	    	   console.log(data);
	    	   if(data.indexOf("0") > -1){
	    		   $( "#error" ).append("Vous n'êtes pas autorisé.");
	    	   }else{
	    		   window.location = 'http://localhost:8080/musee_catho/admin/index.jsp';
	    	   }
	       }
	    });
	
}
function signIn(){
	var pseudo = $( "#inputPseudo" ).val(); 
	var password = $( "#inputPassword" ).val(); 
	console.log(password+" -- "+pseudo);
	
	
	$.ajax({
	       url : 'admin/sign.action?admin=0',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data     : {
	    	   "pseudo": pseudo,
	    	   "password": password
	    	},
	       success : function(data){
	    	   console.log(data);
	    	   if(data.indexOf("0") > -1){
	    		   $( "#error" ).append("Vous n'êtes pas autorisé.");
	    	   }else{
	    		   window.location = 'http://localhost:8080/musee_catho/index.jsp';
	    	   }
	       }
	    });
	
}