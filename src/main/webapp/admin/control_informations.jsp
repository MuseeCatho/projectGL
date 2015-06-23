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


	<s:if test="%{#session.id_userAdmin!=null}">
<s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="informations_manager"/>
	</jsp:include>

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
		<div class="col-sm-6 col-sm-offset-3 col-md-8 col-md-offset-2 main">


			<form id="update_info" action="updateContact.action" method="post">

				<div class="form-group">
					<s:iterator value="listMuseum">
						<label for="phone">Numéro de téléphone</label>
						<input type="text" value="<s:property value="phone" />"
							class="form-control" id="phone" name="phone"
							placeholder="Entrer un numéro de téléhpone">
					</s:iterator>
				</div>
				<div class="form-group">
					<s:iterator value="listMuseum">
						<label for="address">Adresse</label>
						<input type="text" value="<s:property value="address" />"
							class="form-control" id="address" name="address"
							placeholder="Entrer une adresse">
					</s:iterator></div>

					<div class="form-group"><s:iterator value="listMuseum">
						<label for="mail">Adresse Mail</label> <input type="text"
							value="<s:property value="mail" />" class="form-control"
							id="mail" name="mail"
							placeholder="Entrer l'adresse mail de contact du musée">
							</s:iterator>	
					
		</div>

					<div class="form-group"><s:iterator value="listMuseum">
						<label for="description_f">Description acceuil français</label>
						<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
						<textarea class="form-control" id="description_f"
							name="description_f"
							placeholder="Entrer une description pour la page d'acceuil"
							rows="3"><s:property value="description_f" /></textarea>
							</s:iterator>	
					</div>
					<div class="form-group"><s:iterator value="listMuseum">
						<label for="description_e">Description acceuil en anglais</label>
						<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
						<textarea class="form-control" id="description_e"
							name="description_e"
							placeholder="Entrer une description pour la page d'acceuil"
							rows="3"><s:property value="description_e" /></textarea>
							</s:iterator>	
					</div>
					<div class="form-group"><s:iterator value="listMuseum">
						<label for="schedule">Horraires</label> <input type="text"
							class="form-control" id="schedule" name="schedule"
							value="<s:property value="schedule" />"
							placeholder="Entrer les horraires du musée">
							</s:iterator>	
					</div>
					<div class="form-group">
					<s:iterator value="listMuseum">
						<label for="access">Accès</label> <input type="text"
							value="<s:property value="access" />" class="form-control"
							id="access" name="access"
							placeholder="Entrer les moyens d'accès au musée">
							</s:iterator>	
					</div>

					<div style="margin-left: 0px;">
					
						<s:submit value="submit" name="submit" cssClass="btn btn-default" />
					
					</div>

				</form>
		
<<<<<<< HEAD
        </div>
        <div class="col-sm-6 col-sm-offset-3 col-md-8 col-md-offset-2 main">


			<form id="update_info" action="updateContact.action" method="post">

				<div class="form-group">
					<s:iterator value="listMuseum">
						<label for="phone">Numéro de téléphone</label>
						<input type="text" value="<s:property value="phone" />"
							class="form-control" id="phone" name="phone"
							placeholder="Entrer un numéro de téléhpone">
					</s:iterator>
				</div>
				<div class="form-group">
					<s:iterator value="listMuseum">
						<label for="address">Adresse</label>
						<input type="text" value="<s:property value="address" />"
							class="form-control" id="address" name="address"
							placeholder="Entrer une adresse">
					</s:iterator></div>

					<div class="form-group"><s:iterator value="listMuseum">
						<label for="mail">Adresse Mail</label> <input type="text"
							value="<s:property value="mail" />" class="form-control"
							id="mail" name="mail"
							placeholder="Entrer l'adresse mail de contact du musée">
							</s:iterator>	
					
		</div>

							
					<div class="form-group">
						
							<s:iterator value="listMuseum">
						<label for="description_f">Description acceuil français</label>
						<textarea class="form-control" id="description_f" name="description_f" placeholder="Entrer une description pour la page d'acceuil" rows="3">
						<s:property value="presentation_f" />
						</textarea>

							</s:iterator>	
					</div>
					<div class="form-group"><s:iterator value="listMuseum">
						<label for="description_e">Description acceuil en anglais</label>
						<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
						<textarea class="form-control" id="description_e"
							name="description_e"
							placeholder="Entrer une description pour la page d'acceuil"
							rows="3"><s:property value="presentation_e" /></textarea>
							</s:iterator>	
					</div>
					<div class="form-group"><s:iterator value="listMuseum">
						<label for="schedule">Horraires</label> <input type="text"
							class="form-control" id="schedule" name="schedule"
							value="<s:property value="schedule" />"
							placeholder="Entrer les horraires du musée">
							</s:iterator>	
					</div>
					<div class="form-group">
					<s:iterator value="listMuseum">
						<label for="access">Accès</label> <input type="text"
							value="<s:property value="access" />" class="form-control"
							id="access" name="access"
							placeholder="Entrer les moyens d'accès au musée">
							</s:iterator>	
					</div>

					<div style="margin-left: 0px;">
					
						<s:submit value="submit" name="submit" cssClass="btn btn-default" />
					
					</div>

				</form>
		

		</div>
     </s:if>

	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>
	</s:else>

</body>
</html>