<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
#title-adv_research{
	color:#545aff;
	cursor:pointer;
	text-decoration: underline;
	margin-top:50px;
}
</style>
<h6 class="col-lg-9 col-lg-offset-2" id="title-adv_research">Cliquez ici pour une recherche avancée</h6>
<div id="div_adv_research" style="display:none;" class="col-lg-9 col-lg-offset-2">	

<form id="adv_research" action="advanced_research_action.action">
	<fieldset>
	  <div class="form-group">
	    <label for="keyword">Le titre de l'objet contient les mots suivants: </label>
	    <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Entrer un ou plusieurs mots-clés">
	  </div>
	   <div class="form-group">
	    <label for="keywordExclude">Ces mots sont exclus de la recherche:</label>
	    <input type="text" class="form-control" id="keywordExclude" name="keywordExclude" placeholder="Exclure ces mots de la recherche">
	  </div>
	  <div class="form-group">
	    <label for="reference">Réference de l'objet</label>
	    <input type="text" class="form-control" id="reference" name="reference" placeholder="Entrer la réference de l'objet si elle existe">
	  </div>
			<div class="form-group">
				<label for="period"> Période </label>
				<s:select label="Sélectionner la periode de l'objet" headerKey="-1"
					list="listP" listKey="id" listValue="name" name="period"
					id="period" value="defaultSearchEngine" cssClass="form-control" />
			</div>

			<div class="form-group">
				<label for="categories"> Catégorie </label>
				<s:checkboxlist id="categories" label="" list="listCategory"
					listKey="id" listValue="name_f" name="categories" />

			</div>
			<div class="form-group">
	    <label for="country">Pays</label>
	    <input type="text" class="form-control" id="country" name="country" placeholder="Entrer le pays d'origine de l'objet">
	  </div>
	    <div class="form-group">
	    <label for="city">Ville</label>
	    <input type="text" class="form-control" id="city" name="city" placeholder="Entrer la ville d'origine de l'objet">
	  </div>
	  

	  <div style="margin-left:0px;">
	  	<s:submit value="Rechercher" name="submit" cssClass="btn btn-default"/>
	  </div>
	  </fieldset>
</form>
</div>