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

  <div class="row">
	<div class="col-lg-8 col-lg-offset-2">
	
<s:iterator value="listObjectPage">

              <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"><s:property value="title_f"/></h3>
                  </div>
                  <div class="panel-body">
                    <div class="col-lg-2"><img src="<s:property value="link_photos"/>" class="img-responsive" alt="Responsive image"></div>
                    <div class="col-lg-2"><s:property value="description_f"/><br/>
                    <s:property value="name"/></div>
                    <div class="col-lg-2 col-lg-offset-5">
                          <div class="btn-group" role="group">
                          <a href="detail.jsp?id=<s:property value="idObject"/>">
                          <button type="button" class="btn btn-default">Details</button>
                          </a>
                          
                              </div>
                    </div>
                  </div>
              </div>
</s:iterator>

		</div>
	</div>
		
			<s:include value="footer.jsp"></s:include>
</div>
 
    <!-- Include Javascript -->
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">

</script>
  </body>
</html>