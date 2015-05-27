function delete_category(id){ 
	var r = confirm("Voulez-vous vraiment supprimer cette categorie?");
	if (r == true) {
		$.ajax({
		       url : 'deleteCategory.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "id_category": id,
		    	},
		       success : function(data){
		    	   getCategory();
		       }
		    });
	}
}

function addCategory(){ 
	// alert("test");
	var title_f = $( "#title_f" ).val(); 
	var title_e = $( "#title_e" ).val(); 
	var file = $( "#file1" ).val();
	alert("file : "+file);
		  $.ajax({
		       url : 'addCategory.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       encryption: "multipart/form-data",
		       async: true,
		       data: {
		    	   "title_f": title_f,
		    	   "title_e": title_e,
		    	   "link_category": file
		    	},
		       success : function(data){
		    	   getCategory();
		       }
		    }); 
}

function getCategory(){ 
	$( "#listOeuvre" ).empty();
	
		 $.ajax({
		       url : 'getAllCategory.action',
		       type : 'POST',
		       contentType: "application/json",
		       encoding:"UTF-8",
		       async: true,
		       success : function(data){
		    	   var res = data.replace(/&quot;/g, "\"");
		    	   console.log(res);
		    	   console.log("res.length: "+res.length);
		    	   var jsoParse=JSON.parse(res);
		    	   console.log("jsoParse.length : "+jsoParse.length);

	   	    	   for (var i = 0; i < jsoParse.length; i++) {
	   	    		    console.log("id : "+jsoParse[i].id);
	   	    		    console.log("name_f: "+jsoParse[i].name_f);
	   	    		    $('#listOeuvre').append('<div class="col-lg-3">'+
	   	    		          '<img class="img-circle" src="../'+jsoParse[i].link_category+'" width="140" height="140">'+
	   	    		          '<a class="cursor_delete" onmouseover="" onclick="delete_category('+jsoParse[i].id+')"><img class="cancel_category" src="../img/icon/cancel.png" width="30" height="30"></a>'+
	   	    		          '<h2>'+jsoParse[i].name_f+'</h2>'+
	   	    		          '<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod.</p><p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p></div>');
	   	    	   } 	    	   
		       }
		    });
}
getCategory();