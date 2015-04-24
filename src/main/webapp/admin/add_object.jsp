<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <s:include value="header_admin.jsp"></s:include>

 <s:include value="tab_control.jsp"></s:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des oeuvres</h1>

<form>
	  <div class="form-group">
	    <label for="title_f">Titre de l'objet</label>
	    <input type="text" class="form-control" id="title_f" name="title_f" placeholder="Entrer un titre qui definit l'objet de maniere principale">
	  </div>
	  <div class="form-group">
	    <label for="description_f">Description de l'objet</label>
	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet">
	  </div>
	  <div class="form-group">
	    <label for="reference">R�ference de l'objet</label>
	    <input type="text" class="form-control" id="reference" name="reference" placeholder="Entrer la r�ference de l'objet si elle existe">
	  </div>

	  <button type="submit" class="btn btn-default" onclick="AddObjectAdmin()">Valider</button>
</form>

</body>
</html>