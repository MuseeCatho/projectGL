<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    	<s:include value="import.jsp"></s:include>
			<script src="http://malsup.github.com/jquery.form.js"></script>
			<!-- Include css styles here -->
			<link href="../css/fileUpload.css" rel="stylesheet" type="text/css" />
			<script src="../js/category.js"></script> 
			<title>Gestion des categories</title>
	</head>
<style type="text/css">
    .cancel_category{margin-bottom:105px;}
    .cursor_delete{cursor: pointer; }
</style>
  
<body>


  <s:include value="header_admin.jsp"></s:include> 
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="objects_manager"/>
	</jsp:include>
	
	
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"><a href="control_informations.jsp">Gestion des informations</a>  > Gestion des categories</h1>
          
          <h3 class="page-header">Ajout d'une categorie</h3>
          
		       <%-- <form action="addCategory.action" method="post">
		       	<s:submit value="submit" name="Submit bis" cssClass="btn btn-default"/>
		       </form> --%>
		       
		       
		       <form id="UploadForm" action="addCategory.action" method="post" enctype="multipart/form-data">
		       
			       <div class="container-fluid">
			            <div class="row">
			              <div class="col-md-4">
							  <label for="title_f">Titre (en francais)*</label>
		        			  <input class="form-control" id="title_f" name="title_f" type="text" required>
						  </div>
			              <div class="col-md-4 col-md-offset-2">
			              		<label for="title_e">Titre (en anglais)</label>
		        			  	<input class="form-control" id="title_e" name="title_e" type="text">
			              </div>
			              </br>
			              </div>
			              <div class="row">
				              <div class="col-md-4">
						              
								</div>
			            	</div>
			            <div class="row">
			            	<div class="col-md-4">
			              		<p>* champs obligatoires</p></br>
			              		 <div id="errorInscription" style="color:red;"></div>
			              	</div>
			            </div>
			            </br>
			            <div class="row">
			            	<label for="file1">Importer une image : </label> <input type="file" size="60" id="file1" name="upload" /> <br />
									<s:submit value="submit" name="submit" cssClass="btn btn-default"/>


			            </div>
			          </div>
									
				</form>
          </br></br>
          <h3 class="page-header">Liste des categories</h3>
          
          <div id="listOeuvre">
          </div>
		
		</div>
</body>
</html>