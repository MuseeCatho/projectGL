/**
 * 
 */
function addComment(user_id){
	
	//alert(user_id);
	var text=$('#commentObject').val();
	var object_id = getUrlParameter('id');
	//alert(text);
	//alert(test);
	
	$.ajax({
	       url : 'addComment.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data     : {
	    	   "user_id": user_id,
	    	   "object_id": object_id,
	    	   "text":text,
	    	},
	       success : function(data){
	    	   //alert("addcomme");
	    	  window.location = 'http://localhost:8080/musee_catho/detailObject.action?id='+object_id;
	       }
	    });
}

function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
} 