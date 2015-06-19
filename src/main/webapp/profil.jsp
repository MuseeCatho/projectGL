<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<s:include value="import.jsp"></s:include>
	<title>Profil</title>
	<style type="text/css">
    #formChangeProfil{margin-top:100px}
  </style>
</head>

  <body>
  <s:include value="header.jsp"></s:include>
    <div class="container">


            

       <form data-toggle="validator" role="form" id="formChangeProfil">

		        
		        	<div class="row"><!-- PSEUDO -->
		              <div class="col-md-4">
						  <label for="pseudo_profil">Pseudo*</label>
	        			  <input class="form-control" id="pseudo_profil" type="text" required autofocus>
					  </div>
					  <div class="col-md-4 col-md-offset-2" id="checkPseudo"></div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="name_profil">Nom*</label>
	        			  <input class="form-control" id="name_profil" type="text" required>
					  </div>
		              <div class="col-md-4 col-md-offset-2">
		              		<label for="firstName_profil">Prenom*</label>
	        			  	<input class="form-control" id="firstName_profil" type="text" required>
		              </div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="email_profil">Email*</label>
	        			  <input class="form-control" id="email_profil" type="email" required>
					  </div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="country_profil">Pays*</label>
	        			  <input class="form-control" id="country_profil" type="text" required>
					  </div>
		              <div class="col-md-4 col-md-offset-2">
		              		<label for="city_profil">Ville*</label>
	        			  <input class="form-control" id="city_profil" type="text" required>
		              </div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="job_profil">Métier</label>
	        			  <input class="form-control" id="job_profil" type="text">
					  </div>
		            </div>
		            </br>
		            <div class="row">
		            	<div class="col-md-4">
		              		<p>* champs obligatoires</p>
		              		 <div id="errorInscription" style="color:red;"></div>
		              	</div>

			              <div class="col-md-3 col-md-offset-6" >
		            			<button type="button" class="btn btn-primary" onclick="saveChange(<s:property value="#session.id_user" />);">Sauvegarder</button> 
		       				</div>
		            </div>
		       
		       </form>
		       <hr>
		       
		       
		       <form data-toggle="validator" role="form">		           
		            <div class="form-group">
			            <div class="row">
			              <div class="form-group col-md-4">
							  <label for="old_password" class="control-label">Ancien mot de passe*</label>
		        			  <input class="form-control" size="4" id="oldPassword" type="password" required>
						  </div>
						</div>
						<div class="row">
			              <div class="form-group col-md-4" >
			              		<label for="new_password" class="control-label">Nouveau mot de passe*</label>
		        			  <input class="form-control" data-match="#password" id="new_password" type="password" required>
			              </div>
			              <div class="form-group col-md-4 col-md-offset-2" >
			              		<label for="confirm_new_password" class="control-label">Confirmation nouveau mot de passe*</label>
		        			  <input class="form-control" data-match="#password" id="confirm_new_password" type="password" required>
			              </div>
			              <div class="col-md-4 col-md-offset-2" id="errorConfirmPassword"></div>
		              </div>
			         
		            </div>	
		            <div class="row">
			              <div class="form-group col-md-4 col-md-offset-6" >	          
		            			<button type="button" class="btn btn-primary" onclick="saveChange(<s:property value="#session.id_user" />);">Sauvegarder le nouveau mot de passe</button> 
		       			</div>
		            </div>
		       </form>
		</div>

		        
        
        <s:include value="footer.jsp"></s:include>

 
    <!-- Include Javascript -->
    <script type="text/javascript">
    function getInfoUser(id){ 
    	 $.ajax({
    	       url : 'getProfil.action',
    	       encoding:"UTF-8",
    	       async: true,
    	       data     : {
    	    	   "id": id
    	    	},
    	       success : function(data){
    	    	   var res = data.replace(/&quot;/g, "\"");
    	    	   console.log(res);
    	    	   var jsoParse=JSON.parse(res);

    	    	   $('#pseudo_profil').val(jsoParse.pseudo);
    	    	   $('#name_profil').val(jsoParse.name);
    	    	   $('#firstName_profil').val(jsoParse.firstname);
    	    	   $('#email_profil').val(jsoParse.mail);
    	    	   $('#country_profil').val(jsoParse.country);
    	    	   $('#city_profil').val(jsoParse.city);
    	    	   $('#job_profil').val(jsoParse.job);

    	       }
    	    });	 
    }
    function saveChange(id){
    	//alert("id : "+id);
    	 $.ajax({
 	       url : 'updateProfil.action',
 	       encoding:"UTF-8",
 	       async: true,
 	       data     : {
 	    	   "id": id,
 	    	   "pseudo": $('#pseudo_profil').val(),
 	    	   "firstname": $('#firstName_profil').val(),
 	    	   "name": $('#name_profil').val(),
 	    	   "email": $('#email_profil').val(),
 	    	   "country": $('#country_profil').val(),
 	    	   "city": $('#city_profil').val(),
 	           "job": $('#job_profil').val()
 	    	},
 	       success : function(data){
 	    	   alert("Vos données personnelles ont été enregistrés.")
 	       }
 	    }); 
    }
   getInfoUser(<s:property value="#session.id_user" />);
    
    </script>
 
  </body>
</html>