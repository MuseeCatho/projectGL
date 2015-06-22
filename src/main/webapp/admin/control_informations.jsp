<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Gestion des informations</title>
<s:include value="import.jsp"></s:include>
<script src="http://malsup.github.com/jquery.form.js"></script>
<link href="../css/fileUpload.css" rel="stylesheet" type="text/css" />
<script src="../js/control_information.js"></script>
</head>
<body>

	<s:if test="%{#session.id_user!=null}">
<s:include value="header_admin.jsp"></s:include>

	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="informations_manager" />
	</jsp:include>

	<div class="col-sm-5 col-sm-offset-3 col-md-6 col-md-offset-2 main">
		<h1 class="page-header">Gestion des informations</h1>

		<a href="get_category.action">Gestion des categories</a></br> <a
			href="get_period.action">Gestion des périodes</a> <br> <br>


		<form id="UploadForm" action="addPhotoPresentation.action"
			method="post" enctype="multipart/form-data">


			</br>
			<div class="row">
				<label for="file1">Importer une image : </label> <input type="file"
					size="60" id="file1" name="upload" /> <br />
				<s:submit value="submit" name="submit" cssClass="btn btn-default" />
		</form>
	</div>

	</br>

	<s:iterator value="listMuseum">

		<form id="update_info" action="updateContact.action" method="post">
			<div class="form-group">
				<label for="phone">Numéro de téléphone</label> <input type="text"
					value="<s:property value="phone" />" class="form-control"
					id="phone" name="phone" placeholder="Entrer un numéro de téléhpone">
			</div>
			<div class="form-group">
				<label for="address">Adresse</label> <input type="text"
					value="<s:property value="address" />" class="form-control"
					id="address" name="address" placeholder="Entrer une adresse">
			</div>

			<div class="form-group">
				<label for="mail">Adresse Mail</label> <input type="text"
					value="<s:property value="mail" />" class="form-control" id="mail"
					name="mail" placeholder="Entrer l'adresse mail de contact du musée">
			</div>

			<div class="form-group">
				<label for="description_f">Description acceuil français</label>
				<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
				<textarea class="form-control" id="description_f"
					name="description_f"
					placeholder="Entrer une description pour la page d'acceuil"
					rows="3"><s:property value="description_f" /></textarea>
			</div>
			<div class="form-group">
				<label for="description_e">Description acceuil en anglais</label>
				<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
				<textarea class="form-control" id="description_e"
					name="description_e"
					placeholder="Entrer une description pour la page d'acceuil"
					rows="3"><s:property value="description_e" /></textarea>
			</div>
			<div class="form-group">
				<label for="schedule">Horraires</label> <input type="text"
					class="form-control" id="schedule" name="schedule"
					value="<s:property value="schedule" />"
					placeholder="Entrer les horraires du musée">
			</div>
			<div class="form-group">
				<label for="access">Accès</label> <input type="text"
					value="<s:property value="access" />" class="form-control"
					id="access" name="access"
					placeholder="Entrer les moyens d'accès au musée">
			</div>

			<div style="margin-left: 0px;">
				<s:submit value="submit" name="submit" cssClass="btn btn-default" />
			</div>

		</form>

	</s:iterator>
=======
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des informations</h1>
         
         <a href="get_category.action">Gestion des categories</a></br>
         <a href="get_period.action">Gestion des périodes</a>
         <br><br> 
         <div class="col-md-8 ">
	         <form id="UploadForm2" action="addPhotoPresentation.action" method="post" enctype="multipart/form-data">
			       
				            </br>
				            
				            	<label for="file3">Importer une image : </label> 
				            	<input type="file" size="60" id="file3" name="upload" /> <br />
								<s:submit value="submit" name="submit" cssClass="btn btn-default"/>
				            
			</form>
		</div>
		

		<img src="../<s:property value="linkPhoto"/>" width="200px" class="img-responsive" alt="Responsive image">
		
        </div>
     </s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
>>>>>>> 0f95860e25c5b64987d40f7cff621366a668ef1e
</body>
</html>