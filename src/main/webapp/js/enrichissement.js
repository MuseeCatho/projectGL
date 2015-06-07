var arrayImage1 = new Array();
var arrayImage2 = new Array();
var arrayImageUpload = new Array();
var object = {};
var text_modified = false;

function toggle() {
	$('#carouselPhotos').toggle();
	$('#annulationProposition').toggle();
	$('#listPhotos').toggle();
	$('#modif_description').toggle();
}
function reset() {
	
	$('#buttonChange').val('Proposer une modification');
	for (var int = 0; int < arrayImage1.length; int++) {
		$('#icon_cancel' + arrayImage1[int]).css('display', 'inherit');
		$('#icon_ok' + arrayImage1[int]).css('display', 'none');
	}
	$('#descriptionDetail_text').show();

	document.getElementById('modif_text').parentNode.removeChild(document
			.getElementById('modif_text'));
	document.getElementById('result').innerHTML = "";

	var prev = document.getElementById('prev');
	prev.innerHTML = "";
	

	arrayImage1 = [];
	arrayImage2 = [];
	arrayImageUpload = [];
	toggle();
}

function hideEnr(idUser) {
	if ($('#buttonChange').val() == 'Proposer une modification') {
		$('#buttonChange').val('Terminer les modification');
		var e = document.getElementById('descriptionDetail_text');
		save_text = $.trim(e.innerHTML);
		var d = document.createElement('textarea');
		d.innerHTML = $.trim(e.innerHTML); // innerText ne fonctionne pas sur
		// firefox, � modifier...
		e.parentNode.insertBefore(d, e);
		$('#descriptionDetail_text').hide();
		d.id = "modif_text";
		$('#modif_text').addClass("form-control");
		toggle();
	} else {
		var r = confirm("Confimer les modifications?");
		if (r == true) {
			SaveModif(arrayImage2, object, idUser, arrayImageUpload);
			reset();
		}
	}
}
var text = document.getElementById('descriptionDetail_text').innerHTML;
text = $.trim(text);// supprime les espaces au debut de la chaine de caracteres
var list_text = text.split(" ");
var list_text_insert;
var list_word_delete = [];
var list_string_insert = [];
var list_index_delete = [];
var list_word_delete_string;

function description_modifie() {
	var text_insert = document.getElementById('modif_text').value;
	list_text = text.split(" ");
	list_text_insert = text_insert.split(" ");
	var length_text_origin = list_text.length;
	var length_text_modified = list_text_insert.length;

	list_string_insert = [];
	list_word_delete = [];
	list_index_delete = [];
	list_word_delete_string = [];
	var count = 0;
	var gap = 0;// decalage du texte modifi�
	var gap2 = 0;// decalage du texte d'origine
	for (var j = 0; j < Math.max(length_text_origin, length_text_modified); j++) {
		var pos_X = -1;
		if (list_text[j + gap2] != list_text_insert[j + gap]
				&& typeof list_text[j + gap2] != "undefined") {
			console.log(list_text[j + gap2]);
			console.log(list_text_insert[j + gap]);
			var k = j;
			var word_delete = "";
			var first = 1;

			while (pos_X == -1) {// on devrait executer cette boucle que
				// lorsqu'on est s�r qu'il s'agit d'une
				// suppression
				// console.log(list_text[k+gap2]);
				pos_X = list_text_insert.indexOf(list_text[k + gap2], j + gap);
				// console.log("pos_X: "+pos_X);
				var notdoublon = false;
				if (pos_X == -1) {// si le mot suivant dans list_text n'existe
					// pas
					// dans list_insert c'est qu'il a �t� supprim�
					// donc il faut chercher le mot suivant

					list_word_delete.push(k + gap2);// on stocke les mots
					// supprim�s
					if (first == 1)// pour une phrase supprim� on stocke
						// l'indice
						// de son premier mot
						list_index_delete.push(k);// on ne rajoute pas gap2
					// car on list_index_delete
					// stocke des indices pour
					// la list list_text_insert
					// et non list_text
					word_delete += list_text[k + gap2] + " ";
					first++;
					k++;
					notdoublon = true;
				} else {// si on trouve le mot en question c'est qu'il y a deux
					// possibilit�s, soit le mot trouv� est en r�alit� un
					// autre mot et donc le mot en question � �t� supprim�
					// soit il y eu insertion de mot

					var list_of_doublon_index_text_modified = indexOfCount(
							list_text_insert, list_text[k + gap2], j + gap);
					var list_of_doublon_index = indexOfCount(list_text,
							list_text[k + gap2], j + gap2);
					var doublon = false;
					if (list_of_doublon_index_text_modified.length < list_of_doublon_index.length) {// il y
						// a
						// forcement
						// eu
						// suppression
						// du
						// mot
						// QUELQUE
						// PART
						console.log(list_of_doublon_index_text_modified);
						console.log(list_of_doublon_index);
						list_word_delete.push(k + gap2);// k+gap2=13
						if (first == 1)// pour une phrase supprim� on stocke
							// l'indice de son premier mot
							list_index_delete.push(k);
						word_delete += list_text[k + gap2] + " ";
						first++;
						doublon = true;
						k++;
						pos_X = -1;// on le met � -1 de maniere a rester dans
						// la boucle for

					} else {// dans ce cas ce n'est pas forcement une non
						// suppression puisque l'utilisateur pourrait
						// inserer du texte plus loin contenant le m�me mot
						// console.log(list_of_doublon_index_text_modified);
						// console.log(list_of_doublon_index);
						notdoublon = true;
					}
					// pos_X=-1;
					// break;

				}

				if ((k + gap2) > list_text.length - 1) {
					break;
				}

			}

			if (word_delete != "")// insertion des mots supprim�s
				list_word_delete_string.push(word_delete);
			// ci dessous � modifier
			if (!doublon || notdoublon) {
				for (var i = j + gap; i < pos_X; i++) {// stocke � priori les
					// indices
					// des mots qui on �t� ins�r�s
					list_string_insert.push(i);
					// console.log("i :"+i);

				}
			}

			gap = list_string_insert.length;
			gap2 = list_word_delete.length;// 1
			// console.log("list_index_delete: "+list_index_delete.length+"count

			// :"+count);
			// for(var i=count;i<list_index_delete.length;i++){
			// console.log(list_index_delete[i]-gap);
			// list_index_delete[i]=list_index_delete[i]-gap;
			// }
			if (list_index_delete.length - 1 == 1)
				// console.log(list_index_delete[list_index_delete.length-1])
				if (word_delete != "")
					list_index_delete[list_index_delete.length - 1] += gap;

			// -------------------------------------------------------------------------------
			// pos_X=list_text_insert.indexOf(list_text[j],j+gap)-1;
			// for(var i=j+gap;i<=pos_X;i++){
			// list_string_insert.push(i);

			// }
			// gap=list_string_insert.length;
			count++;
		} else if (typeof list_text[j + gap2] == 'undefined') {
			list_string_insert.push(j + gap);
		}
	}
	var result = "";
	// var list_index_delete=compact_list_num(list_word_delete);
	var index_word_delete;
	var word_delete_index = 0;
	for (var k = 0; k < list_text_insert.length; k++) {
		index_word_delete = k;
		// index_word_delete=k;
		// if(list_word_delete.indexOf(index_word_delete)!=-1){
		// while(list_word_delete.indexOf(index_word_delete)!=-1){
		// result+='<s><span
		// style="color:red">'+list_text[index_word_delete]+'</span></s>'+" ";
		// console.log(list_text[index_word_delete]+" "+"index_word_delete:
		// "+index_word_delete);
		// index_word_delete++;
		// }

		// }

		if (list_index_delete.indexOf(k) != -1) {
			// while(list_word_delete.indexOf(index_word_delete)!=-1){
			// result+='<s><span
			// style="color:red">'+list_text[index_word_delete]+'</span></s>'+"
			// ";
			// console.log(list_text[index_word_delete]+" "+"index_word_delete:
			// "+index_word_delete);

			// index_word_delete++;
			// }
			result += '<s><span style="color:red">'
					+ list_word_delete_string[word_delete_index]
					+ '</span></s>' + " ";
			word_delete_index++;
		}
		if (list_string_insert.indexOf(k) != -1) {
			result += '<b><span style="color:green">' + list_text_insert[k]
					+ '</span></b>' + " ";
		} else {
			result += list_text_insert[k] + " ";
		}
	}
	result = document.getElementById('result').innerHTML = result;

	return result;
}

function compact_list_num(list) {
	var new_list = [ list[0] ];
	for (var k = 1; k <= list.length; k++) {
		if (list[k] != list[k - 1] + 1) {
			new_list.push(list[k - 1]);
		}
	}
	return new_list;
}

function indexOfCount(list, element, begin) {
	if (list.indexOf(element) == -1) {
		return [];
	}

	// var hash={
	// "indexes":[]
	// };
	var list_index = [];
	for (var j = begin; j < list.length; j++) {
		if (list[j] == element) {
			// hash["indexes"].push(j);
			list_index.push(j);
		}
	}
	return list_index;
}

function annulation() {
	var r = confirm("Annuler les modifications et revenir à la page de l'oeuvre?");
	if (r == true) {
		reset();
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
	
	if (type == 'image') {
		if (etat == "delete") {
			var r = confirm("Voulez-vous vraiment supprimer cette image?");
		}
			var id_medias = id;
		

		if ((r && etat=="delete") || etat=="add") {
			object = {
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
	var today = new Date();
	var date = today.toLocaleDateString();
	var user_id = idUser;
	var new_description = document.getElementById('result').innerHTML;
	var source = "";
	var object_id = getQueryVariable("id");
	$.ajax({
		url : 'addEnrichments.action',
		type : 'POST',
		encoding : "UTF-8",
		async : false,
		data : {
			"user_id" : user_id,
			"object_id" : object_id,
			"new_description" : new_description,
			"source" : source,
			"date" : date
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

function getLastPhotosId() {
	$.ajax({
		url : 'getLastPhotosId.action',
		type : 'POST',
		contentType : "application/json",
		encoding : "UTF-8",
		async : false,
		context : this,
		success : function(data) {
			var res = data.replace(/&quot;/g, "\"");
			var jsoParse = JSON.parse(res);
			var lastIdPho;
			for (var i = 0; i < jsoParse.length; i++) {
				this.lastIdPho = jsoParse[i].id;
			}
			return lastIdPho;
		}
	});
}

function addPhotos() {
	var name_f = "";
	var name_e = "";
	var object_id = getQueryVariable("id");
	var showI = true;

	$.ajax({
		url : 'addPhotos.action',
		type : 'POST',
		encoding : "UTF-8",
		async : false,
		data : {
			"object_id" : object_id,
			"name_f" : name_f,
			"name_e" : name_e,
			"showI" : showI
		},
		success : function(data) {
		}
	});
	
}

function SaveModif(arrayImage2, object, idUser, arrayImageUpload) {
	if (arrayImageUpload.length != 0) {
		for (var int = 0; int < arrayImageUpload.length; int++) {
			var arrayImageString = arrayImageUpload[int];
			$.ajax({
				url : 'addMedia.action',
				type : 'POST',
				encoding : "UTF-8",
				encryption : "multipart/form-data",
				async : false,
				data : {
					"listImageUploadS" : arrayImageString
				},
				success : function(data) {
				},
			});
			addPhotos();
			getLastPhotosId();
			addProposition("image", lastIdPho, "add");
		}
		
	}
	if (arrayImage2.length != 0 || text_modified) {
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

(function(listDetailIncr) {

	var listDetailIncr = 0;
	function createThumbnail(file, arrayImageUpload) {
		var reader = new FileReader();
		reader.addEventListener('load', function() {
			var divElement = document.createElement('div');
			var incr = "listDetail" + listDetailIncr;
			divElement.id = incr;
			divElement.className = "col-xs-4 col-sm-3 col-md-2 photoDetailAdd";
			prev.appendChild(divElement);

			var imgElement = document.createElement('img');
			imgElement.id = "listPhotosImg";
			imgElement.src = this.result;
			document.getElementById(incr).appendChild(imgElement);
			var iconeElement = document.createElement('a');
			var classIncr = "classIcon" + listDetailIncr;
			iconeElement.id = classIncr;
			iconeElement.className = "cursor_cancel";
			document.getElementById(incr).appendChild(iconeElement);
			var imgIconeElement = document.createElement('img');
			var iconeIncr = "addIcon_cancel" + listDetailIncr;
			imgIconeElement.id = iconeIncr;
			imgIconeElement.className = "icon icon_cancel";
			imgIconeElement.src = "img/icon/cancel.png";
			imgIconeElement.addEventListener('click', function() {
				deleteAdd(incr);
			}, false);
			document.getElementById(classIncr).appendChild(imgIconeElement);
			listDetailIncr++;
			arrayImageUpload.push(imgElement.src);
		}, false);
		reader.readAsDataURL(file);
	}

	var allowedTypes = [ 'png', 'jpg', 'jpeg', 'gif' ], fileInput = document
			.querySelector('#file'), prev = document.querySelector('#prev');
	fileInput.addEventListener('change', function() {
		var files = this.files, filesLen = files.length, imgType;
		for (var i = 0; i < filesLen; i++) {
			imgType = files[i].name.split('.');
			imgType = imgType[imgType.length - 1];
			if (allowedTypes.indexOf(imgType) != -1) {
				createThumbnail(files[i], arrayImageUpload);
			}
		}
	}, false);

})();

function deleteAdd(incr) {
	var r = confirm("Supprimer l'image?");
	if (r == true) {
		var obj = document.getElementById('prev');
		var old = document.getElementById(incr);
		obj.removeChild(old);
	} else {
		alert("Aucune modification n'a �t� d�t�ct�.");
	}
}

function modifieText() {
	if ($.trim(description_modifie()) != $.trim(document
			.getElementById('descriptionDetail_text').innerHTML)) {// si
		// l'utilisateur
		// a modifi�
		// le texte
		return true;
	} else {
		return false;
	}

}

function saveModifDescr() {
	if (modifieText()) {
		text_modified = true;
		alert('Modification prise en compte.');
	} else {
		alert("Vous n'avez pas fait de modifications.");
		return false;
	}
}