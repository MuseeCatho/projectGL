function signInAdmin(){
	var login = $( "#inputEmail" ).val(); 
	var password = $( "#inputPassword" ).val(); 
	console.log(password+" -- "+login);
	
	
	$.ajax({
	       url : 'signIn.action',
	       type : 'POST',
	       contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data     : {
	    	   "login": login,
	    	   "password": password
	    	},
	       success : function(data){
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