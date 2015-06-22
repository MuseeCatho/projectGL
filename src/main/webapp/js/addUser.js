function addUser(){
	
	//on vide les erreurs si il y en a
	$('#errorInscription').text("");
	
	var name = $( "#name" ).val(); 
	var firstname = $( "#firstname" ).val(); 
	var pseudo = $("#pseudo").val();
	var email = $("#email").val();
	var password = $("#password").val();
	var country = $("#country").val();
	var city = $("#city").val();
	var job = $("#job").val();
	//alert("name : "+name + "____ pseudo :"+pseudo);
	if(name=="" || firstname=="" || pseudo=="" || email=="" || password=="" || country=="" || city==""){
		
		$('#errorInscription').append("Tous les champs ne sont pas remplis");
	}else{
		if(validateEmail(email)){
					if(checkPasswordMatch()==0){
						$('#errorInscription').append("Erreur lors de la saisie du mot de passe.");
					}else{		
						checkPseudoMatch(function(result) {
							
						if(result==1){
							$('#errorInscription').append("Pseudo non disponible.");
						}else{
						
								$.ajax({
								       url : 'add_user.action',
								       type : 'POST',
								       //contentType: "application/json",
								       encoding:"UTF-8",
								       async: true,
								       data: {
								    	   "name": name,
								    	   "firstname": firstname,
								    	   "pseudo":pseudo,
								    	   "email":email,
								    	   "password":password,
								    	   "country": country,
								    	   "city" : city,
								    	   "job" : job
								    	},
								       success : function(data){
								    	   window.location = 'index.action';
								       }
								    });
						}
						
						});
					
					
					}
		}else{
			$('#errorInscription').append("Le format du mail n'est pas valide");
		}
	}

}

$(document).ready(function () {
	   $("#confirm_password").keyup(checkPasswordMatch);
	   $("#password").keyup(checkPasswordMatch);
	   $("#pseudo").keyup(checkPseudoMatchForm);
});

function checkPasswordMatch() {
	//alert("confirm_password");
    var password = $("#password").val();
    var confirmPassword = $("#confirm_password").val();

    if(password.length<5 || confirmPassword.length<5){
    	$("#errorConfirmPassword").html("<div class=\"alert alert-danger\" role=\"alert\">Le mot de passe doit contenir au moins 6 caracteres</div>");
    	return 0;
    }else{
    	if (password != confirmPassword){
            $("#errorConfirmPassword").html("<div class=\"alert alert-danger\" role=\"alert\">Confirmation mot de passe incorrect</div>");
        	return 0;
        }else{
            $("#errorConfirmPassword").html("<div class=\"alert alert-success\" role=\"alert\">Confirmation mot de passe correct</div>");
        	return 1;
        }
    }
}

function checkPseudoMatch(callback) {
    var pseudo = $("#pseudo").val();
    var valueReturn=0;
    
    
    $.ajax({
	       url : 'checkPseudo.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data: {
	    	   "pseudo": pseudo
	    	},
	    	 success : callback
	    });
}
function checkPseudoMatchForm(callback) {
    var pseudo = $("#pseudo").val();
    var valueReturn=0;
    
    
    $.ajax({
	       url : 'checkPseudo.action',
	       type : 'POST',
	       //contentType: "application/json",
	       encoding:"UTF-8",
	       async: true,
	       data: {
	    	   "pseudo": pseudo
	    	},
	       success : function(data){
	    	   if(data.indexOf("0") > -1){
	    		   $("#checkPseudo").html("<div class=\"alert alert-success\" role=\"alert\">Pseudo disponible</div>");
	    	   }else{
	    		   $("#checkPseudo").html("<div class=\"alert alert-danger\" role=\"alert\">Pseudo non disponible</div>");   
	    	   } 	  
	       }
	    });
}
function validateEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}
