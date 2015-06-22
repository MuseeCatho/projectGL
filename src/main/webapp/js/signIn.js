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
	    		   $( "#error" ).append("Pseudo ou mot de passe incorrect.");
	    	   }else{
	    		   window.location = '../admin/index.jsp';
	    	   }
	       }
	    });
	
}
function signIn(){
	$( "#error" ).empty();
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
	    		   $( "#error" ).append("Login ou mot de passe incorrect.");
	    	   }else{
	    		   $('.login').modal('hide');
	    		   window.location = 'index.action';
	    	   }
	       }
	    });
	
}
function logOut(){
	console.log("logout");
	
	
	$.ajax({
	       url : 'logOut.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       success : function(data){
	    	   window.location = 'index.action';
	       }
	    });
	
}
function logOutAdmin(){
	$.ajax({
	       url : 'logOut.action',
	       type : 'POST',
	       encoding:"UTF-8",
	       async: true,
	       success : function(data){
	    	   window.location = '../admin/login.jsp';
	       }
	    });
	
}