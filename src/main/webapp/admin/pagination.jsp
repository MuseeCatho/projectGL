<%@taglib uri="/struts-tags" prefix="s"%>
<div class="paginationContainer">
	<ul class="pagination">
		<s:iterator value="pageLis">
			<s:property escape="false" />
		</s:iterator>
	</ul>
</div>