function hideEnr() {
	$('#carouselPhotos').toggle();
	$('#listPhotos').toggle();
}

function addProposition(type, id, etat) {
	if (type = 'image') {
		var r = confirm("Voulez-vous vraiment supprimer cette image?");
		if (r == true) {
			var today = new Date();
			var date = today.toLocaleDateString();
			var id_audio = 0;
			var id_photos = id;
			var id_videos = 0;
		}
		var id_enrichments = 1;
		$.ajax({
			url : 'addProposition.action',
			type : 'POST',
			encoding : "UTF-8",
			async : true,
			data : {
				"date" : date,
				"etat" : etat,
				"type" : type,
				"id_audio" : id_audio,
				"id_photos" : id_photos,
				"id_videos" : id_videos,
				"id_enrichments" : id_enrichments
			},
			success : function(data) {
			}
		});
	}
}