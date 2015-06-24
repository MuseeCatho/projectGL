function getListProposition(idEnrichment) {
	var arrayIdMediasList = [];
	var arrayEtatList = [];
	var arrayTypeList = [];
	var res;
	$.ajax({
		url : 'getListProposition.action',
		type : 'POST',
		encryption : "multipart/form-data",
		encoding : "UTF-8",
		async : false,
		data : {
			"idEnrichment" : idEnrichment
		},
		success : function(data) {
			res = data.replace(/&quot;/g, "\"");
			return res;

		}
	});

	var jsoParse = JSON.parse(res);
	for (var i = 0; i < jsoParse.length; i++) {
		arrayIdMediasList.push(jsoParse[i].id_medias);
		arrayEtatList.push(jsoParse[i].etat);
		arrayTypeList.push(jsoParse[i].type);
	}

	if (arrayIdMediasList != 0) {
		
		$('.photoDetail').css({
			'background-color' : '#eee',
			'border': '3px solid rgb(38, 90, 136)'
		})
		for (var i = 0; i < arrayIdMediasList.length; i++) {
			if (arrayEtatList[i] == "delete") {
				$('.image' + arrayIdMediasList[i]).css({
					'background-color' : '#ccc',
					'border' : '6px solid rgb(164, 0, 0)'
				})
			}
		}
	}
}

function reset() {
	// $.ajax({
	/*
	 * url : 'propositions_detailAjax.jsp', type : 'POST', encryption :
	 * "multipart/form-data", encoding : "UTF-8", async : false, success :
	 * function(data) {alert(data); $('#container').innerHTML=data;
	 * $('#container').html(data); } });
	 */

}
