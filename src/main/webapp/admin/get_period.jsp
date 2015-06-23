<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Gestion des categories</title>
	<s:include value="import.jsp"></s:include>
</head>
<style type="text/css">
    .cancel_category{margin-bottom:105px;}
    .cursor_delete{cursor: pointer; }
  </style>
  
<body>

<s:if test="%{#session.id_userAdmin!=null}">

 <s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="informations_manager"/>
	</jsp:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"><a href="control_informations.action">Gestion des informations</a>  > Gestion des périodes</h1>
          
          <h3 class="page-header">Ajout d'une période</h3>
          
          <form data-toggle="validator" role="form">     
		        <div class="container-fluid">
		            <div class="row">
		              <div class="col-md-4">
						  <label for="title_period">Titre de la période*</label>
	        			  <input class="form-control" id="title_period" type="text" required>
					  </div>
		              <div class="col-md-4">
						  <label for="date">Date</label>
	        			  <input class="form-control" id="date" type="text" required>
					  </div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="description_f">Description (en francais)</label>
	        			  <textarea class="form-control" id="description_f" type="text"></textarea>
					  </div>
		              <div class="col-md-4">
						  <label for="description_e">Description (en anglais)</label>
	        			  <textarea class="form-control" id="description_e" type="text"></textarea>
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
		        <button type="button" class="btn btn-primary" onclick="addPeriod()">Ajouter</button> 
		       </form>
          </br></br>
          
          
          <h3 class="page-header">Liste des périodes</h3>
                 
          <table class="table table-condensed" id="tabPeriod">
           <thead>
		      <tr>
		      	<th>Ordre</th>
		        <th>Nom des périodes</th>
		        <th>Date</th>
		        <th>Description francais</th>
		        <th>Description anglais</th>
		        <th>Suprimer</th>
		        <th>Modifier</th>
		      </tr>
		    </thead>
		    <tbody>
		    </tbody>
		  </table>
		</div>

</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>

<script>
function delete_period(id){ 
	var r = confirm("Voulez-vous vraiment supprimer cette période ?");
	if (r == true) {
		$.ajax({
		       url : 'deletePeriod.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "id_category": id,
		    	},
		       success : function(data){
		    	   window.location = 'get_period.action';
		       }
		    });
	}
}

function addPeriod(){ 
	var title_period = $( "#title_period" ).val(); 
	var date = $( "#date" ).val(); 
	var description_e = $( "#description_e" ).val();
	var description_f = $( "#description_f" ).val();
	
		 $.ajax({
		       url : 'addPeriod.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "title_period": title_period,
		    	   "date": date,
		    	   "description_e": description_e,
		    	   "description_f": description_f
		    	},
		       success : function(data){
		    	   window.location = 'get_period.action';
		       }
	});
		 
}

function update_period(id){ 
	// on reconstitue l'id pour l'input
	var idInput="#idInput"+id;
	var orderPeriod= $(idInput).val(); 
	//alert("periode order :"+orderPeriod);
	 	 $.ajax({
		       url : 'upadtePeriod.action',
		       type : 'POST',
		       encoding:"UTF-8",
		       async: true,
		       data: {
		    	   "id_category": id,
		    	   "orderPeriod": orderPeriod
		    	},
		       success : function(data){
		    	   window.location = 'get_period.action';
		       }
	}); 
		 
}


function getPeriod(){ 
	//$( '#tabPeriod').empty();
	//$('#tabPeriod tbody').remove();
	
	
	
		 $.ajax({
		       url : 'getAllPeriod.action',
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
	   	    		    console.log("name_f: "+jsoParse[i].name);
	   	    		    if(jsoParse[i].date==null){
	   	    		    	jsoParse[i].date="non définie";
	   	    		    }
		   	    		 if(jsoParse[i].description_e==null){
		   	    		    	jsoParse[i].description_e="non définie";
		   	    		    }
		   	    		if(jsoParse[i].description_f==null){
	   	    		    	jsoParse[i].description_f="non définie";
	   	    		    }
	   	    		 	$('#tabPeriod tr:last').after('<tr><td class="col-md-1"><input id="idInput'+jsoParse[i].id+'" class="form-control" value="'+jsoParse[i].order+'" id="date" type="text" required></td><td>'+jsoParse[i].name+
	   	    		 			'</td>'+'<td>'+jsoParse[i].date+'</td>'+
	   	    		 			'<td class="col-md-4">'+jsoParse[i].description_f+'</td>'+
	   	    		 			'<td class="col-md-4">'+jsoParse[i].description_e+'</td>'+
	   	    		 			'<td><a class="cursor_delete" onmouseover="" onclick="delete_period('+jsoParse[i].id+')"><img src="../img/icon/cancel.png"></td></a>'
	   	    		 +
    		 			'<td><a class="cursor_delete" onmouseover="" onclick="update_period('+jsoParse[i].id+')"><img src="../img/icon/modify.png"></td></a></tr>');
	   	    	   }
	   	    	
		       }
		    });
}
getPeriod();




</script>
</body>
</html>