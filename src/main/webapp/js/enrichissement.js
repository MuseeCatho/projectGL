var arrayImage1 = new Array();
var arrayImage2 = new Array();
var object = {};

function hideEnr(idUser) {
	if ($('#buttonChange').val() == 'Proposer une modification') {
		$('#buttonChange').val('Terminer les modification');
		$('#carouselPhotos').toggle();
		$('#listPhotos').toggle();
	} else {
		var r = confirm("Confimer les modifications?");
		if (r == true) {
			SaveModif(arrayImage2, object, idUser);
			$('#buttonChange').val('Proposer une modification');
			for (var int = 0; int < arrayImage1.length; int++) {
				$('#icon_cancel' + arrayImage1[int]).css('display', 'inherit');
				$('#icon_ok' + arrayImage1[int]).css('display', 'none');
			}
			arrayImage1 = [];
			arrayImage2 = [];
			$('#carouselPhotos').toggle();
			$('#listPhotos').toggle();
		}
	}
}

function changeState(id) {
	$('#icon_cancel' + id).toggle();
	$('#icon_ok' + id).toggle();
	if ($.inArray(id, arrayImage1) == -1) {
		arrayImage1.push(id);
	}
}

function cancelProposition(type, id) {
	var r = confirm("Voulez-vous annuler votre proposition de modification?");
	if (r == true) {
		for (var int = 0; int < arrayImage2.length; int++) {
			if (arrayImage2[int].id_medias == id) {
				arrayImage2 = arrayImage2.slice(1);
			}
		}
		changeState(id);
	}
}

function addProposition(type, id, etat) {
	var today = new Date();
	var date = today.toLocaleDateString();
	if (type = 'image') {

		var r = confirm("Voulez-vous vraiment supprimer cette image?");
		if (r == true) {
			var id_medias = id;
			object = {
				"date" : date,
				"etat" : etat,
				"type" : type,
				"id_medias" : id_medias,
			}

			arrayImage2.push(object);

			changeState(id);
		}
	}

	return object;
}
function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	return (false);
}

function addEnrichments(idUser) {
	var user_id = idUser;
	var new_description = "";
	var source = "";
	var object_id = getQueryVariable("id");
	$.ajax({
		url : 'addEnrichments.action',
		type : 'POST',
		encoding : "UTF-8",
		async : false,
		data : {
			"object_id" : object_id,
			"user_id" : user_id,
			"new_description" : new_description,
			"source" : source
		},
		success : function(data) {
		}
	});
}

function getLastEnrichmentsId() {
	$.ajax({
		url : 'getLastEnrichmentId.action',
		type : 'POST',
		contentType : "application/json",
		encoding : "UTF-8",
		async : false,
		context : this,
		success : function(data) {
			var res = data.replace(/&quot;/g, "\"");
			var jsoParse = JSON.parse(res);
			var lastIdEnr;
			for (var i = 0; i < jsoParse.length; i++) {
				this.lastIdEnr = jsoParse[i].id;
			}
			return lastIdEnr;
		}
	});
}

function SaveModif(arrayImage2, object, idUser) {
	if (arrayImage2.length != 0) {
		addEnrichments(idUser);
		getLastEnrichmentsId();
		if (lastIdEnr != 0 && lastIdEnr != null) {
			for (var int = 0; int < arrayImage2.length; int++) {
				arrayImage2[int].id_enrichments = lastIdEnr;
				$.ajax({
					url : 'addProposition.action',
					type : 'POST',
					encoding : "UTF-8",
					async : true,
					data : arrayImage2[int],
					success : function(data) {
					}
				});

			}
		}
	}
}