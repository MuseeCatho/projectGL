<%@ taglib prefix="s" uri="/struts-tags"%>
<table class="table table-hover">
	<caption>Membres (<s:property value="numberUsers"/>):</caption>
	<thead>
		<tr>
			<th>pseudo</th>
			<th>email</th>
			<th>prénom</th>
			<th>nom</th>
			<th>pays</th>
			<th>ville</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="users">
			<tr>
				<td><s:property value="pseudo" /></td>
				<td><s:property value="mail" /></td>
				<td><s:property value="firstname" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="country" /></td>
				<td><s:property value="city" /></td>
			</tr>
		</s:iterator>
</table>