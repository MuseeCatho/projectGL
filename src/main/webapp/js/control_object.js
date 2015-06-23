function getComment(idObject,booleanToogle){

	
	$('#tabCommentById_'+idObject).empty();
	if(booleanToogle){
		$("#blockTable_"+idObject).toggle();
	}
	
	//$("#tabCommentById_"+idObject).empty();
	//var rowCount = $('#tabCommentById_'+idObject+' tr').length;
	//console.log(rowCount);
	

			//alert("getCommentID");
			//alert(idObject);
			$.ajax({
			       url : 'getCommentById.action',
			       type : 'POST',
			       encoding:"UTF-8",
			       async: true,
			       data:{
			    	   "object_id":idObject
			       },
			       success : function(data){
			    	   //alert(data);
			    	   
			    	   
			    	   var res = data.replace(/&quot;/g, "\"");
			    	   //console.log(res);
			    	   //console.log("res.length: "+res.length);
			    	   var jsoParse=JSON.parse(res);
			    	   //console.log("jsoParse.length : "+jsoParse.length);
			    	   
			    	   for (var i = 0; i < jsoParse.length; i++) {
			    		    //console.log("id : "+jsoParse[i].id);
			    		    //console.log("pseudo : "+jsoParse[i].pseudo);
			    		    //console.log("text : "+jsoParse[i].text);
			    		    //console.log("date : "+jsoParse[i].date);
			    		   if(jsoParse[i].show==0){
				    		    $('#tabCommentById_'+idObject).append('<tr><td class="col-md-1">'+jsoParse[i].pseudo+'</td><td>'+jsoParse[i].text+
			   	    		 	'</td><td><a class="cursor_delete" onmouseover="" onclick="valid_comment('+jsoParse[i].id+','+idObject+')"><img width="30px" src="../img/icon/ok.png"></td></a>'+
			   	    		 	'<td class="col-md-4"><a class="cursor_delete" onmouseover="" onclick="cancel_comment('+jsoParse[i].id+','+idObject+')"><img src="../img/icon/cancel.png"></td></a></td></tr>');
				    		 }
			    	   }
			       }
			    });

}

function cancel_comment(id,idObject){ 

	 	 $.ajax({
		       url : 'deleteComment.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "id": id
		    	},
		       success : function(data){
		    	   //$('#tabCommentById_'+idObject+' tr').remove();
		    	   getComment(idObject,false);
		    	  //alert('ok');
		       }
	 	 }); 
		 
}

function valid_comment(id,idObject){ 

	 $.ajax({
	       url : 'valideComment.action',
	       type : 'POST',
	       encoding:"UTF-8",
	       async: true,
	       data: {
	    	   "id": id
	    	},
	       success : function(data){
	    	   getComment(idObject,false);
	    	  //alert('ok');
	       }
	 }); 
	 
}
function delete_object(id){
	var r = confirm("Voulez-vous vraiment supprimer cet objet?");
	if (r == true) {
		$.ajax({
		       url : 'deleteObject.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "id": id
		    	},
		       success : function(data){
		    	   window.location='../admin/control_object.action?orderObject=true';
		    	  //alert('L\'objet a bien été supprimé.');
		       }
		 });
	}
	
}


