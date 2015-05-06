<% String pageName = request.getParameter("pageName");%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
			
				<li<%if (pageName != null && pageName.equals("welcome"))out.print(" class=\"active\"");%>>
					<a href="index.jsp">Accueil<span class="sr-only">(current)</span></a>
				</li>
				<li<%if (pageName != null && pageName.equals("profile_manager"))out.print(" class=\"active\"");%>>
					<a href="profil.jsp">Gestion de profil<span class="sr-only">(current)</span></a>
				</li>
				<li<%if (pageName != null && pageName.equals("objects_manager"))out.print(" class=\"active\"");%>>
					<a href="control_object.jsp">Gestion des oeuvres<span class="sr-only">(current)</span></a>
				</li>
				<li<%if (pageName != null && pageName.equals("users_manager"))out.print(" class=\"active\"");%>>
					<a href="users_manager.jsp">Gestion des membres<span class="sr-only">(current)</span></a>
				</li>
				<li<%if (pageName != null && pageName.equals(""))out.print(" class=\"active\"");%>>
					<a href="index.jsp">Gestion des informations<span class="sr-only">(current)</span></a>
				</li>
			</ul>
		</div>
	</div>
</div>