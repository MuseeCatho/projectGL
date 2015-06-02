<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url id="localeFR" namespace="/" action="locale" >
   	<s:param name="request_locale" >fr</s:param>
</s:url>
<s:url id="localeEN" namespace="/" action="locale" >
   <s:param name="request_locale" >en</s:param>
</s:url>

<nav class="navbar navbar-default">

              <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#">Brand</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                    <li><a href="index.action"><s:text name="global.home" /><span class="sr-only">(current)</span></a></li>
                    <li><a href="getOeuvre.action"><s:text name="global.art" /></a></li>
                    <li><a href="map.jsp"><s:text name="global.map" /></a></li>
                    <li><a href="contact.jsp"><s:text name="global.contact" /></a></li>
                    
                    
                    <s:if test="%{#session.firstname!=null}">
						<li><a href="profil.action"><s:property value="#session.firstname" /></a></li>
					</s:if>
					<s:else>
					  
					</s:else>
					
					
                  </ul>
                  <form class="navbar-form navbar-left" role="search" action="research_action.action">
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="<s:text name="global.keyWord" />" name="research">
                    </div>
                    <button type="submit" class="btn btn-default"><s:text name="global.search" /></button>
                  </form>


                   <form class="navbar-form navbar-right" role="search">
                    <div class="btn-group">
                          <button type="button" class="btn btn-danger">Langues</button>
                          <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                          </button>
                          <ul class="dropdown-menu" role="menu">
                            <li>
                            	<s:a href="%{localeFR}" >Francais</s:a>
							</li>
                            <li>
                            	<s:a href="%{localeEN}" >English</s:a>
                            </li>
                          </ul>
                    </div>
                  </form>

					<s:if test="%{#session.firstname!=null}">
						<button type="button" class="btn btn-primary navbar-btn" onclick="logOut()"><s:text name="global.logout" /></button>
					</s:if>
					<s:else>
					  <button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target=".login"><s:text name="global.login" /></button>
                   
                   	  <button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target=".inscription"><s:text name="global.signIn" /></button>
                   
					</s:else>
                   
                   
                </div><!-- /.navbar-collapse -->
              </div><!-- /.container-fluid -->
            </nav>
            
            
            
            
            <!-- MODAL INSCRIPTION-->
            <div class="modal fade inscription" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Inscription</h4>
		      </div>
		      <form data-toggle="validator" role="form">
		      <div class="modal-body">
		      
		      
		        <div class="container-fluid">
		        
		        	<div class="row"><!-- PSEUDO -->
		              <div class="col-md-4">
						  <label for="pseudo">Pseudo*</label>
	        			  <input class="form-control" id="pseudo" type="text" required autofocus>
					  </div>
					  <div class="col-md-4 col-md-offset-2" id="checkPseudo"></div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="name">Nom*</label>
	        			  <input class="form-control" id="name" type="text" required>
					  </div>
		              <div class="col-md-4 col-md-offset-2">
		              		<label for="firstName">Prenom*</label>
	        			  	<input class="form-control" id="firstname" type="text" required>
		              </div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="email">Email*</label>
	        			  <input class="form-control" id="email" type="email" required>
					  </div>
		            </div>
		            <div class="form-group">
			            <div class="row">
			              <div class="form-group col-md-4">
							  <label for="password" class="control-label">Mot de passe*</label>
		        			  <input class="form-control" size="4" id="password" type="password" required>
						  </div>
						</div>
						<div class="row">
			              <div class="form-group col-md-4" >
			              		<label for="confirm_password" class="control-label">Confirmation mot de passe*</label>
		        			  <input class="form-control" data-match="#password" id="confirm_password" type="password" required>
			              </div>
			              <div class="col-md-4 col-md-offset-2" id="errorConfirmPassword"></div>

		              </div>
			         
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="country">Pays*</label>
	        			  <input class="form-control" id="country" type="text" required>
					  </div>
		              <div class="col-md-4 col-md-offset-2">
		              		<label for="city">Ville*</label>
	        			  <input class="form-control" id="city" type="text" required>
		              </div>
		            </div>
		            <div class="row">
		              <div class="col-md-4">
						  <label for="job">M�tier</label>
	        			  <input class="form-control" id="job" type="text">
					  </div>
		            </div>
		            </br>
		            <div class="row">
		            	<div class="col-md-4">
		              		<p>* champs obligatoires</p></br>
		              		 <div id="errorInscription" style="color:red;"></div>
		              	</div>
		            </div>
		          </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" onclick="addUser()">Je m'inscris</button> 
		      </div>
		       </form>
		    </div>
		  </div>
		</div>
		
		<!-- MODAL LOGIN-->
            <div class="modal fade login" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Login</h4>
		      </div>
		      <div class="modal-body">
					        <label for="inputEmail" class="sr-only">Email address</label>
					        <input id="inputPseudo" class="form-control" placeholder="Pseudo" required autofocus>
					        <label for="inputPassword" class="sr-only">Password</label>
					        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
					        <div id="error" style="color:red;"></div>			      
		      </div>
		      <div class="modal-footer">

		        <button type="button" class="btn btn-primary" onclick="signIn()">Sign in</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
</div>