<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  
  <style type="text/css">
    #container{position:relative;width:100%;margin:auto;}
    .carousel-inner{
        height: 500px;
    }
    #pres{
        margin-top: 100px;
        width:90%;
    }
  </style>
  <body>
    <div id="container">


   <s:include value="header.jsp"></s:include>
	
<s:iterator value="listObjectPage">	
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">
            <div class="col-lg-4">
                <a href="#">
                    <img src="<s:property value="link_photos"/>" class="img-responsive" alt="Responsive image">
                </a>
            </div>
            <div class="col-md-8">
                <h3><s:property value="title_f"/></h3>
                <p><s:property value="description_f"/></p>
                <a href="detailObject.action?id=<s:property value="idObject"/>">View Project <span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
     </div>
     <hr>
</s:iterator>
		
			<s:include value="footer.jsp"></s:include>
</div>
 
    <!-- Include Javascript -->
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">

</script>
  </body>
</html>