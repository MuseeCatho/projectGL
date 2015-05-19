var arrayImage1 = new Array();
var arrayImage2 = new Array();
var arrayImage = new Array(arrayImage1, arrayImage2);

function hideEnr() {
	if ($('#buttonChange').val() == 'Proposer une modification') {
		$('#buttonChange').val('Terminer les modification');
		$('#carouselPhotos').toggle();
		$('#listPhotos').toggle();
	} else {
		var r = confirm("Confimer les modifications?");
		if (r == true) {
			SaveModif(arrayImage2);
			$('#buttonChange').val('Proposer une modification');
			arrayImage1 = [];
			arrayImage2 = [];
			$('#carouselPhotos').toggle();
			$('#listPhotos').toggle();
		}
	}
}

function addProposition(type, id, etat) {
	var today = new Date();
	var date = today.toLocaleDateString();
	if (type = 'image') {

		var r = confirm("Voulez-vous vraiment supprimer cette image?");
		if (r == true) {
			var id_audio = 0;
			var id_photos = id;
			var id_videos = 0;

			var id_enrichments = 1;
			var object = {
				"date" : date,
				"etat" : etat,
				"type" : type,
				"id_audio" : id_audio,
				"id_photos" : id_photos,
				"id_videos" : id_videos,
				"id_enrichments" : id_enrichments
			}
			arrayImage1.push(id_photos);
			arrayImage2.push(object);
		}

	}
}

function SaveModif(arrayImage2) {
	alert(arrayImage2)
	for (var int = 0; int < arrayImage2.length; int++) {
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