
/*function signIn(){
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
	    		   window.location = 'http://localhost:8080/musee_catho/index.jsp';
	    	   }
	       }
	    });
	
}*/

function AddObjectAdmin(){
	
	var title_f = $( "#title_f" ).val(); 
	var description_f = $( "#description_f" ).val(); 
	var reference = $("#reference").val();
	console.log("console:"+title_f+" "+description_f);
	$.ajax({
	       url : 'admin/add_object_test.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data: {
	    	   "title_f": title_f,
	    	   "description_f": description_f,
	    	   "reference":reference
	    	},
	       success : function(data){
	    	   console.log(data);
	    	   if(data.indexOf("0") > -1){
	    		   alert("ok2");
	    		   //$( "#title_f" ).append("Login ou mot de passe incorrect.");
	    	   }else{
	    		  // $('.login').modal('hide');
	    		   alert("ok");
	    		  // window.location = 'http://localhost:8080/musee_catho/admin/index.jsp';
	    	   }
	       }
	    });
}
