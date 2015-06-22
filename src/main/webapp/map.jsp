<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
 
<html>
 
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<s:include value="import.jsp"></s:include>
	 <style type="text/css">
    #map{width:1000px;height:550px;margin:auto;margin-top:100px}
    .myInfoWindow{width: 180px;}
  </style>
	<title>Map</title>
</head>
  <body>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<s:include value="header.jsp"></s:include>
		<div class="row">
	       <div id="map">
	            <p>Veuillez patienter pendant le chargement de la carte...</p>
	        </div>
        </div>
   <s:include value="footer.jsp"></s:include>
 
    <!-- Include Javascript -->
   
    <script type="text/javascript" src="js/map.js"></script>
  </body>
</html>