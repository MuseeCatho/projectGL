
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<s:include value="import.jsp"></s:include>

<title>Museum</title>
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<div id="contact">
		<div class="row">
			<div class="row top-buffer" id="pres">
				<div class="col-lg-8 col-lg-offset-1">

					<h2><s:text name="global.textContact" /></h2>
				</div>
			</div>
		</div>
		<div class="row"></div>
		<div class="row"></div>
		<div class="row top-buffer" id="pres">
			<div class="col-lg-4 col-lg-offset-1">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h2 class="panel-title"><s:text name="global.informationMuseum" /></h2>
					</div>
					<div class="panel-body">
						<ul>
							<s:iterator value="listMuseum">
								<li><strong><s:text name="global.phoneNumber" /> :</strong> <s:property value="phone" /></li>
								</br>
								<li><strong><s:text name="global.address" />  :</strong> <s:property value="address" /></li>
								</br>
								<li><strong><s:text name="global.busUnderground" /> :</strong> <s:property value="access" /></li>
								</br>
								<li><strong><s:text name="global.horaire" /> :</strong> <s:property value="schedule" /></li>
								</br>
								<li><strong><s:text name="global.mail" /> :</strong> <s:property value="mail" /></li>
							</s:iterator>
						</ul>
					</div>
				</div>

			</div>

			<div class="col-lg-5 col-lg-offset-1" ; style :"display:inline-block ; margin: 40 px">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h2 class="panel-title"><s:text name="global.plan" /></h2>
					</div>
					<div class="panel-body">
						<p>
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2625.534067789134!2d2.329608499999999!3d48.848025500000006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e671d1b3942161%3A0x43136ee9c5a5bf3f!2s21+Rue+d&#39;Assas%2C+75006+Paris!5e0!3m2!1sfr!2sfr!4v1432719758036"
								width="500" height="350" frameborder="0" style="border: 0"></iframe>
						</p>



					</div>

				</div>
			</div>
		</div>


		<s:include value="footer.jsp"></s:include>

	</div>


</body>
</html>