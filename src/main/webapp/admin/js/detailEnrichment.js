function getListProposition(idEnrichment) {
	reset();
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
		for (var i = 0; i < arrayIdMediasList.length; i++) {
			if (arrayEtatList[i] == "delete") {
				$('.image' + arrayIdMediasList[i]).css({
					'background-color' : '#ccc;',
					border : '6px solid rgb(164, 0, 0)',
				})
			}
		}
	}

}