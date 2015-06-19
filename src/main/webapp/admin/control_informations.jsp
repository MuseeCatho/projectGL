<%@ taglib prefix="s" uri="/struts-tags" %>
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
<s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="informations_manager"/>
	</jsp:include>

        <div class="col-sm-5 col-sm-offset-3 col-md-6 col-md-offset-2 main">
          <h1 class="page-header">Gestion des informations</h1>
         
         <a href="get_category.action">Gestion des categories</a></br>
         <a href="get_period.action">Gestion des périodes</a>
         <br><br>
         
         
         <form id="UploadForm" action="addPhotoPresentation.action" method="post" enctype="multipart/form-data">
		       
			             
			            </br>
			            <div class="row">
			            	<label for="file1">Importer une image : </label> <input type="file" size="60" id="file1" name="upload" /> <br />
									<s:submit value="submit" name="submit" cssClass="btn btn-default"/>


			            </div>
									
				</form>
		
        </div>
</body>
</html>