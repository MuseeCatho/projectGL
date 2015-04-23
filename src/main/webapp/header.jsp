<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script src="js/jquery.js"></script>
		<script src="js/signIn.js"></script>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		        

    <title>Museum</title>
  </head>

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
                    <li><a href="index.jsp">Accueil<span class="sr-only">(current)</span></a></li>
                    <li><a href="oeuvres.jsp">Oeuvres</a></li>
                    <li><a href="map.jsp">Carte</a></li>
                    <li><a href="contact.jsp">Contacts</a></li>
                    
                    <s:if test="%{#session.firstname!=null}">
						<li><a href="profil.jsp"><s:property value="#session.firstname" /></a></li>
					</s:if>
					<s:else>
					  
					</s:else>
					
					
                  </ul>
                  <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="Mot-clef">
                    </div>
                    <button type="submit" class="btn btn-default">Rechercher</button>
                  </form>


                   <form class="navbar-form navbar-right" role="search">
                    <div class="btn-group">
                          <button type="button" class="btn btn-danger">Langues</button>
                          <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                          </button>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Francais</a></li>
                            <li><a href="#">Anglais</a></li>
                          </ul>
                    </div>
                  </form>

					<s:if test="%{#session.firstname!=null}">
						<button type="button" class="btn btn-primary navbar-btn" onclick="logOut()">Log out</button>
					</s:if>
					<s:else>
					  <button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target=".login">Login</button>
                   
                   	  <button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target=".inscription">Incription</button>
                   
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
		      <div class="modal-body">
		        ...
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Je m'inscris</button>
		      </div>
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
		      	
					   
					       <div class="col-lg-7 col-lg-offset-2">
					        <label for="inputEmail" class="sr-only">Email address</label>
					        <input id="inputPseudo" class="form-control" placeholder="Pseudo" required autofocus>
					        <label for="inputPassword" class="sr-only">Password</label>
					        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
					        </div>
					        <div class="col-lg-7 col-lg-offset-2">
					        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="signIn()">Sign in</button>
					        </div>
					        <div id="error"> </div>
					      
				
		      </div>
		      <div class="modal-footer">
		      </div>
		    </div>
		  </div>
		</div>
		