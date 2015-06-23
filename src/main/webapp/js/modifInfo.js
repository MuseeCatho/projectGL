function updateInfoMuseum() {
	
	
	
	$.ajax({
	       url : 'admin/modifContact.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data     : {
	    	   "adress": pseudo,
	    	   "presentation_e": password
	    	},
	       success : function(data){
	    	   
	       }
	    });
}