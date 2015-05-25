<%@ taglib prefix="s" uri="/struts-tags" %>
<form id="add_object" class="col-lg-9 col-lg-offset-2" action="advanced_research_action.action">
	<fieldset>
	  <div class="form-group">
	    <label for="key-word">Le titre de l'objet contient les mots suivants: </label>
	    <input type="text" class="form-control" id="key-word" name="key-word" placeholder="Entrer un ou plusieurs mots-clés">
	  </div>
	   <div class="form-group">
	    <label for="key-word">Ces mots sont exclus de la recherche:</label>
	    <input type="text" class="form-control" id="key-word" name="key-word" placeholder="Exclure ces mots de la recherche">
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
	<label for="period">
	Période
	</label>
<%-- 			<s:select label="Sélectionner la periode de l'objet"  --%>
<%-- 	 		headerKey="-1"  --%>
<%-- 	 		list="listP" --%>
<%-- 	   		listKey="id" --%>
<%-- 	   		listValue="name"   --%>
<%-- 	 		name="period" --%>
<%-- 	 		id="period"  --%>
<%--  			value="defaultSearchEngine" --%>
<%--  			cssClass="form-control" /> --%>
 			
 			<label for="categories">
	Catégorie
	</label>
<%--  			<s:checkboxlist id="categories" label="" list="listCategory" listKey="id" --%>
<%-- 	   		listValue="name_f" name="categories"/> --%>
 			

	  <div style="margin-left:0px;">
	  	<s:submit value="submit" name="submit" cssClass="btn btn-default"/>
	  </div>
	  </fieldset>
</form>



