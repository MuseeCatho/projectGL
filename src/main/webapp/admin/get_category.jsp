<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Gestion des categories</title>
</head>
<style type="text/css">
    .cancel_category{margin-bottom:105px;}
    .cursor_delete{cursor: pointer; }
  </style>
  
<body>
 <s:include value="header_admin.jsp"></s:include>

 <s:include value="tab_control.jsp"></s:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des categories</h1>
          
          <h3 class="page-header">Ajout d'une categorie</h3>
          
          <form data-toggle="validator" role="form">     
		        <div class="container-fluid">
		            <div class="row">
		              <div class="col-md-4">
						  <label for="title_f">Titre (en francais)*</label>
	        			  <input class="form-control" id="title_f" type="text" required>
					  </div>
		              <div class="col-md-4 col-md-offset-2">
		              		<label for="title_e">Titre (en anglais)</label>
	        			  	<input class="form-control" id="title_e" type="text" required>
		              </div>
		            </div>
		            <div class="row">
		            	<div class="col-md-4">
		              		<p>* champs obligatoires</p></br>
		              		 <div id="errorInscription" style="color:red;"></div>
		              	</div>
		            </div>
		            </br>
		          </div>
		        <button type="button" class="btn btn-primary" onclick="addCategory()">Ajouter</button> 
		       </form>
          </br></br>
          <h3 class="page-header">Liste des categories</h3>
          
          <div id="listOeuvre">
          </div>
        <s:iterator value="listCategory">
	        <div class="col-lg-3">
	          <img class="img-circle" src="../<s:property value="link_category"/>" width="140" height="140">
	          <a class="cursor_delete" onmouseover="" onclick="delete_category(<s:property value="id"/>)"><img class="cancel_category" src="../img/icon/cancel.png" width="30" height="30"></a>
	          <h2><s:property value="name_f"/></h2>
	          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod.</p>
	          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
	        </div>
		</s:iterator>
		
		</div>

<script>
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
		 $.ajax({
		       url : 'addCategory.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "title_f": title_f,
		    	   "title_e": title_e,
		    	   "link_category": null
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
</script>
</body>
</html>