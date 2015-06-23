<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="../js/control_object.js"></script>
	<s:include value="import.jsp"></s:include>
</head>
<style type="text/css">
	.hideBlockTable{display:none;}
	.cancel_category{margin-bottom:105px;}
    .cursor_delete{cursor: pointer; }
</style>
<body>

	<s:if test="%{#session.id_userAdmin!=null}">

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
		                <h3><s:property value="title_f"/> <a class="cursor_delete" onmouseover="" onclick="delete_object(<s:property value="idObject"/>)"><img src="../img/icon/cancel.png"></a></h3>
		                <p><s:property value="description_f"/></p>
		                <button onclick="getComment(<s:property value="idObject"/>,true)" id="button_object_<s:property value="idObject"/>">Nombre de commentaire non validés :<s:property value="commentNotValidate"/></button>
		            </div>
		        </div>
		        <div class="hideBlockTable" id="blockTable_<s:property value="idObject"/>">
			        <table class="table table-condensed" >
			           <thead>
					      <tr>
					      	<th>Pseudo</th>
					        <th>Commentaires</th>
					        <th>Valider</th>
					        <th>Supprimer</th>
					      </tr>
					    </thead>
					    <tbody id="tabCommentById_<s:property value="idObject"/>">
					    </tbody>
					  </table>
		        </div>
		     </div>
		     <hr>
		</s:iterator>
        </div>
        
    </s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
</body>
</html>