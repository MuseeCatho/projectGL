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
		

		<img src="../<s:property value="linkPhoto"/>" width="200px" class="img-responsive" alt="Responsive image">
		
        </div>
     </s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
</body>
</html>