var valueReturn;

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
	$('#errorInscription_profil').text("");
	if($('#pseudo_profil').val()=="" || $('#firstName_profil').val()=="" || $('#name_profil').val()=="" || $('#email_profil').val()=="" || $('#country_profil').val()=="" || $('#city_profil').val()==""){
		
		$('#errorInscription_profil').append("Tous les champs ne sont pas remplis");
	}else{
		if(valueReturn==1){ // si le pseudo est diponible
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
		
		}else{
			$('#errorInscription_profil').append("Pseudo indisponible");
		}
	}
}


function functionTest(id) {
     var pseudo = $("#pseudo_profil").val();
     console.log("id "+id);
     
     $.ajax({
 	       url : 'checkPseudo.action?id='+id,
 	       type : 'POST',
 	       //contentType: "application/json",
 	       encoding:"UTF-8",
 	       async: true,
 	       data: {
 	    	   "pseudo": pseudo,
 	    	   "id":id
 	    	},
 	       success : function(data){
 	    	   if(data.indexOf("0") > -1){
 	    		   $("#checkPseudo_profil").html("<div class=\"alert alert-success\" role=\"alert\">Pseudo disponible</div>");
 	    		  valueReturn=1;
 	    	   }else{
 	    		   $("#checkPseudo_profil").html("<div class=\"alert alert-danger\" role=\"alert\">Pseudo non disponible</div>");   
 	    		  valueReturn=0;
	    	   } 	  
 	       }
 	    });

}