
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<style type="text/css">
</style>
<body>
	<div id="container">


		<s:include value="header.jsp"></s:include>

		<div id="contact">
			<div class="row">
				<div class="row top-buffer" id="pres">
					<div class="col-lg-10 col-lg-offset-1">

						<h2>Vous trouverez sur cette page les informations concernant
							l'accès au musée ainsi que la possibilité de contacter le
							conservateur du musée</h2>
					</div>
				</div>
			</div>
			<div class="row">
			</div>
			<div class="row">
			</div>
				<div class="row top-buffer" id="pres">
					<div class="col-lg-4 col-lg-offset-1">
					
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2 class="panel-title">Information sur le musée</h2>
							</div>
							<div class="panel-body">
								<p>Accès au musée</p>

							</div>
							<ul>
								<li>Numéro de téléphone : </li>
								<li>Adresse : </li>
								<li>Bus/métro : </li>

							</ul>
						</div>
					
				</div>
				
				<div class="row top-buffer" id="pres">
					<div class="col-lg-4 col-lg-offset-5">
					
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h2 class="panel-title">Plan du quartier</h2>
							</div>
							<div class="panel-body">
								<p></p>


							</div>
						</div>
					
				</div>
			</div>
		</div>
		</div>

  	<s:include value="import.jsp"></s:include>



		<s:include value="footer.jsp"></s:include>

	</div>
</body>
</html>