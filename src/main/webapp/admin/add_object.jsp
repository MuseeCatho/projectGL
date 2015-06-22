<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ajout d'un objet</title>
<s:include value="import.jsp"></s:include>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
</head>
<body>
<s:if test="%{#session.id_user!=null}">

 <s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="objects_manager"/>
	</jsp:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des oeuvres</h1>

<form id="add_object">
	  <div class="form-group">
	    <label for="title_f">Titre de l'objet</label>
	    <input type="text" class="form-control" id="title_f" name="title_f" placeholder="Entrer un titre">
	  </div>
	   <div class="form-group">
	    <label for="title_e">Titre de l'objet en anglais</label>
	    <input type="text" class="form-control" id="title_e" name="title_e" placeholder="Entrer un titre">
	  </div>
	  <div class="form-group">
	    <label for="description_f">Description de l'objet</label>
<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
	    <textarea class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet" rows="3"></textarea>
	  </div>
	  <div class="form-group">
	    <label for="description_e">Description de l'objet en anglais</label>
<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
	    <textarea class="form-control" id="description_e" name="description_e" placeholder="Entrer une description de l'objet" rows="3"></textarea>
	  </div>
	  <div class="form-group">
	    <label for="reference">Réference de l'objet</label>
	    <input type="text" class="form-control" id="reference" name="reference" placeholder="Entrer la réference de l'objet si elle existe">
	  </div>
	  <div class="form-group">
	    <label for="country">Pays</label>
	    <input type="text" class="form-control" id="country" name="country" placeholder="Entrer le pays d'origine de l'objet">
	  </div>
	    <div class="form-group">
	    <label for="city">Ville</label>
	    <input type="text" class="form-control" id="city" name="city" placeholder="Entrer la ville d'origine de l'objet">
	  </div>
	  <div class="form-group">
	  <label for="file1">Importer une photo : </label> <input type="file" size="60"
			id="file1" name="upload" /> <br />
		<label for="file2">Importer une photo : </label> <input type="file" size="60"
			id="file2" name="upload" /> <br />
		<label for="file3">Importer une photo : </label> <input type="file" size="60"
			id="file3" name="upload" /> <br />
	  </div>
	     <div class="form-group">
	<label for="period">
	Sélectionner la période de l'objet
	</label>
			<s:select label="Sélectionner la periode de l'objet" 
	 		headerKey="-1" 
	 		list="listP"
	   		listKey="id"
	   		listValue="name"  
	 		name="period"
	 		id="period" 
 			value="defaultSearchEngine"
 			cssClass="form-control" />
 			
 			<label for="categories">
	Sélectionner les catégories
	</label>
 			<s:checkboxlist id="categories" label="" list="listCategory" listKey="id"
	   		listValue="name_f" name="categories"/>
 			
<!--  	<label for="category"> -->
<!-- 	Sélectionner la catégorie de l'objet -->
<!-- 	</label> -->
<%-- 			<s:select label="Sélectionner la periode de l'objet"  --%>
<%-- 	 		headerKey="-1"  --%>
<%-- 	 		list="listCategory" --%>
<%-- 	   		listKey="id" --%>
<%-- 	   		listValue="name_f"   --%>
<%-- 	 		name="category" --%>
<%-- 	 		id="category"  --%>
<%--  			value="defaultSearchEngine" --%>
<%--  			cssClass="form-control" />		 --%>
		
	     </div>
	     <input type="hidden" name="latitude" id="latitude" value="">
	  	 <input type="hidden" name="longitude" id="longitude" value="">

	<!-- 	  <button type="submit" class="btn btn-default" onclick="AddObjectAdmin()">Valider</button> -->
	  <div style="margin-left:0px;"><s:submit value="submit" name="submit" cssClass="btn btn-default"/></div>
	</form>

</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
<script>
// function beforeSubmit(){
function formSubmit(){ 
	$('#add_object').submit(function(event) {
	  //alert('Handler for .submit() called.');
	  AddObjectAdmin();
	  var lng=$("#longitude").val();
	  var lat = $('#latitude').val();
// 	  if(!(lng && lat)){
		  //alert("Fail");
		  event.preventDefault();
		  //alert("re-test");
		 
// 	  }
	});
}
formSubmit();

// }
</script>
</body>
</html>