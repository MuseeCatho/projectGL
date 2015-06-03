<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="pagination.jsp"></s:include>
<table class="table table-hover">
	<caption>
		<strong>
			Membres (
			<s:property value="numberUsers" />
			) :
		</strong>
	</caption>
	<thead>
		<tr>
			<th>pseudo</th>
			<th>email</th>
			<th>prénom</th>
			<th>nom</th>
			<th>pays</th>
			<th>ville</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="users">
			<tr data-toggle="modal"
				data-target="#modalDisplayUser<s:property value="id"/>">
				<td><s:property value="pseudo" /></td>
				<td><s:property value="mail" /></td>
				<td><s:property value="firstname" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="country" /></td>
				<td><s:property value="city" /></td>
				<td class="boutons_container">
					<p>
						<img src="img/bouton-aide-perspective--icone-6877-96.png" title="
							<s:if test="admin==1">
								retirer les droits d'administrateur
							</s:if>
							<s:else>
							    donner les droits d'administrateur
							</s:else>
						" alt= "
							<s:if test="ban==1">
								retirer les droits d'administrateur
							</s:if>
							<s:else>
							    donner les droits d'administrateur
							</s:else>
						" onclick = "event.stopPropagation();prettyAlert('modalPermuteAdminUser<s:property value="id"/>', function(){usersData.permuteAdmin(<s:property value="id"/>);});"
						/>
						<img src="img/bouton-icone-3746-96.png"
							<s:if test="admin==1">
								<s:if test="ban==1">
									title="accepter l'administrateur" alt="accepter l'administrateur"
								</s:if>
								<s:else>
									title="bannir l'administrateur" alt="bannir l'administrateur"
								</s:else>
							</s:if>
							<s:else>
								<s:if test="ban==1">
									title="accepter l'utilisateur" alt="accepter l'utilisateur"
								</s:if>
								<s:else>
									title="bannir l'utilisateur" alt="bannir l'utilisateur"
								</s:else>
							</s:else>
							onclick = "event.stopPropagation();prettyAlert('modalPermuteBanUser<s:property value="id"/>', function(){usersData.permuteBan(<s:property value="id"/>);});"
						"/>
						<img src="img/bouton-annuler-icone-6994-96.png"
							<s:if test="admin==1">
								title="supprimer l'administrateur" alt="supprimer l'administrateur"
							</s:if>
							<s:else>
								title="supprimer l'utilisateur" alt="supprimer l'utilisateur"
							</s:else>
							onclick = "event.stopPropagation();prettyAlert('modalDeleteUser<s:property value="id"/>', function(){usersData.deleteUser(<s:property value="id"/>);});"
						/>
					</p>
				</td>
			</tr>
		</s:iterator>
</table>
<!--  modal -->
<div id="modals">
	<s:iterator value="users">
		<!-- modal for display the user : -->
		<div class="modal fade" id="modalDisplayUser<s:property value="id"/>"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="mediaModal modal-dialog">
				<div class="modal-content">
					<form class="modalForm" data-toggle="validator" role="form">
						<div class="row">
							<!-- PSEUDO -->
							<div class="col-md-4">
								<label for="pseudo_profil">Pseudo*</label> <input
									class="form-control" id="pseudo_profil" type="text" required
									autofocus>
							</div>
							<div class="col-md-4 col-md-offset-2" id="checkPseudo"></div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label for="name_profil">Nom*</label> <input
									class="form-control" id="name_profil" type="text" required>
							</div>
							<div class="col-md-4 col-md-offset-2">
								<label for="firstName_profil">Prenom*</label> <input
									class="form-control" id="firstName_profil" type="text" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label for="email_profil">Email*</label> <input
									class="form-control" id="email_profil" type="email" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label for="country_profil">Pays*</label> <input
									class="form-control" id="country_profil" type="text" required>
							</div>
							<div class="col-md-4 col-md-offset-2">
								<label for="city_profil">Ville*</label> <input
									class="form-control" id="city_profil" type="text" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label for="job_profil">Métier</label> <input
									class="form-control" id="job_profil" type="text">
							</div>
						</div>
						</br>
						<div class="row">
							<div class="col-md-4">
								<p>* champs obligatoires</p>
								<div id="errorInscription" style="color: red;"></div>
							</div>

							<div class="col-md-3 col-md-offset-6">
								<button type="button" class="btn btn-primary"
									onclick="saveChange(<s:property value="#session.id_user" />);">Sauvegarder</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- modals for prevent the actions -->
		<!--  for pemuteAdmin : -->
		<div class="modal fade modalAlert" id="modalPermuteAdminUser<s:property value="id"/>"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<p>
						<span class="msg">Voulez vous vraiment
						<s:if test="admin==1">
							enlever les droits d'administrateur de 
						</s:if>
						<s:else>
							donner les droits d'administrateur à
						</s:else>
						<s:property value="pseudo"/> ?</span>
						<br/><br/>
						<button type="button" class="yes btn btn-primary">Oui</button>
						<button type="button" class="no btn btn-primary">Non</button>
					</p>
				</div>
			</div>
		</div>
		<!--  for pemuteAdmin : -->
		<div class="modal fade modalAlert" id="modalPermuteBanUser<s:property value="id"/>"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<p>
						<span class="msg">Voulez vous vraiment
						<s:if test="admin==1">
							<s:if test="ban==1">
								accepeter l'administrateur
							</s:if>
							<s:else>
								bannir l'administrateur
							</s:else>
						</s:if>
						<s:else>
							<s:if test="ban==1">
								accepeter l'utilisateur
							</s:if>
							<s:else>
								bannir l'utilisateur
							</s:else>
						</s:else>
						<s:property value="pseudo"/> ?</span>
						<br/><br/>
						<button type="button" class="yes btn btn-primary">Oui</button>
						<button type="button" class="no btn btn-primary">Non</button>
					</p>
				</div>
			</div>
		</div>
		<!--  for delete -->
		<div class="modal fade modalAlert" id="modalDeleteUser<s:property value="id"/>"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<p>
						<span class="msg">Voulez vous vraiment
						<s:if test="admin==1">
							supprimer l'administrateur
						</s:if>
						<s:else>
							supprimer l'utilisateur
						</s:else>
						<s:property value="pseudo"/> ?</span>
						<br/><br/>
						<button type="button" class="yes btn btn-primary">Oui</button>
						<button type="button" class="no btn btn-primary">Non</button>
					</p>
				</div>
			</div>
		</div>
	</s:iterator>
</div>
<s:include value="pagination.jsp"></s:include>