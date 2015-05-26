<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<s:include value="import.jsp"></s:include>
</head>
<body>
 <s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="objects_manager"/>
	</jsp:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des oeuvres</h1>

         <a href="add_object.action">Ajouter un objet</a><br>
         
         
         <!-- AFFICHAGE DES OBJETS AVEC LE NOMBRE DE COMMENTAIRES -->
         <s:iterator value="listObjectPage">	
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
		            <div class="col-lg-4">
		                <a href="#">
		                    <img src="../<s:property value="link_photos"/>" class="img-responsive" alt="Responsive image">
		                </a>
		            </div>
		            <div class="col-md-8">
		                <h3><s:property value="title_f"/></h3>
		                <p><s:property value="description_f"/></p>
		                <a href="detailObject.action?id=<s:property value="idObject"/>">View Project <span class="glyphicon glyphicon-chevron-right"></span></a>
		            </div>
		        </div>
		     </div>
		     <hr>
		</s:iterator>
        </div>
</body>
</html>