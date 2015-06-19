<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
		<s:include value="import.jsp"></s:include>
		<script src="../js/signIn.js"></script>
		       
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

	<div class="row">
		
		<div class="col-md-4 col-md-offset-4">
	      <form class="form-signin">
	        <h2 class="form-signin-heading">Please sign in</h2>
	        <label for="inputEmail" class="sr-only">Email address</label>
	        <input id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	        <div class="checkbox">
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="signInAdmin()">Sign in</button>
	        <div id="error"> </div>
	      </form>
	    </div>
    </div>

    </div>
</body>
</html>