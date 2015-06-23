<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
#title-adv_research{
	color:#545aff;
	cursor:pointer;
	text-decoration: underline;
	margin-top:50px;
}
</style>
<h6 class="col-lg-9 col-lg-offset-2" id="title-adv_research"><s:text name="global.clicHere" /></h6>
<div id="div_adv_research" style="display:none;" class="col-lg-9 col-lg-offset-2">	

<form id="adv_research" action="advanced_research_action.action">
	<fieldset>
	  <div class="form-group">
	    <label for="keyword"><s:text name="global.objectTitle" />: </label>
	    <input type="text" class="form-control" id="keyword" name="keyword" placeholder="<s:text name="global.enterKeyWord" />">
	  </div>
	   <div class="form-group">
	    <label for="keywordExclude"><s:text name="global.wordExcluded" />:</label>
	    <input type="text" class="form-control" id="keywordExclude" name="keywordExclude" placeholder="<s:text name="global.enterExcludedWord" />">
	  </div>
	  <div class="form-group">
	    <label for="reference"><s:text name="global.reference" /></label>
	    <input type="text" class="form-control" id="reference" name="reference" placeholder="<s:text name="enterReference" />">
	  </div>
			<div class="form-group">
				<label for="period"><s:text name="global.period" /></label>
				<s:select label="Sélectionner la periode de l'objet" headerKey="-1" headerValue="Indifférente"
					list="listP" listKey="id" listValue="name" name="period"
					id="period" value="defaultSearchEngine" cssClass="form-control" />
			</div>

			<div class="form-group">
				<label for="categories"><s:text name="global.category" /></label>
				<s:checkboxlist id="categories" label="" list="listCategory"
					listKey="id" listValue="name_f" name="categories" />

			</div>
			<div class="form-group">
	    <label for="country"><s:text name="global.country" /></label>
	    <input type="text" class="form-control" id="country" name="country" placeholder="<s:text name="global.enterCountry" />">
	  </div>
	    <div class="form-group">
	    <label for="city"><s:text name="global.city" /></label>
	    <input type="text" class="form-control" id="city" name="city" placeholder="<s:text name="global.enterCity" />">
	  </div>
	  

	  <div style="margin-left:0px;">
	  	<s:submit value="Rechercher" name="submit" cssClass="btn btn-default"/>
	  </div>
	  </fieldset>
</form>
</div>