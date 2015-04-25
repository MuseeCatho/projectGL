<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ajout d'un objet</title>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
</head>
<body>
 <s:include value="header_admin.jsp"></s:include>

 <s:include value="tab_control.jsp"></s:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des oeuvres</h1>

<form id="add_object">
	  <div class="form-group">
	    <label for="title_f">Titre de l'objet</label>
	    <input type="text" class="form-control" id="title_f" name="title_f" placeholder="Entrer un titre">
	  </div>
	  <div class="form-group">
	    <label for="description_f">Description de l'objet</label>
<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
	    <textarea class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet" rows="3"></textarea>
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
<!-- 	     	<label for="period">Sélectionner la periode de l'objet</label> -->
<%-- 	     	<select class="form-control" name="period" id="period"> --%>
<!-- 			  <option value="volvo">Volvo</option> -->
<!-- 			  <option value="saab">Saab</option> -->
<!-- 			  <option value="opel">Opel</option> -->
<!-- 			  <option value="audi">Audi</option> -->
<%-- 			</select> --%>
			<s:select label="Sélectionner la periode de l'objet" 
		headerKey="-1"
		list="#{'Moyen age':'Moyen age', 'Prehistoire':'Prehistoire','Moderne':'Moderne'}" 
		name="period" 
		value="defaultSearchEngine" />
		
		
	     </div>
	     <input type="hidden" name="latitude" id="latitude" value="">
	  	 <input type="hidden" name="longitude" id="longitude" value="">

<!-- 	  <button type="submit" class="btn btn-default" onclick="AddObjectAdmin()">Valider</button> -->
	  <div style="margin-left:0px;"><s:submit value="submit" name="submit" cssClass="btn btn-default"/></div>
</form>
<script>
// function beforeSubmit(){
	var lat_lng=["0","0"];
	 var country=$("#country").val(), city=$("#city").val();
$('#add_object').submit(function(event) {
	  //alert('Handler for .submit() called.');
	  //AddObjectAdmin();

// 	  lat_lng=getLatitudeLongitude(country+","+city, function(num) {
// 			latitude=num.lat();
// 			longitude=num.lng();	
// 	  });
	  alert(lat_lng[0]);
	  document.getElementById("longitude").value=lat_lng[0];
	  document.getElementById("latitude").value=lat_lng[1];
	  return true;
	});
// }
</script>
</body>
</html>