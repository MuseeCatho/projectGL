<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%-- <script src="soundmanager/js/berniecode-animator.js"></script> --%>
<%-- 	<script src="soundmanager/js/soundmanager2.js"></script> --%>
<%-- 	<script src="soundmanager/js/360player.js"></script> --%>
<script type="text/javascript" src="../js/alert.js"></script>
<script type="text/javascript" src="../js/FormData2.js"></script>
<script type="text/javascript" src="../js/mediaManager.js"></script>
<title>Ajout d'un objet</title>
<s:include value="import.jsp"></s:include>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
</head>
<body>
<s:if test="%{#session.id_userAdmin!=null}">

 <s:include value="header_admin.jsp"></s:include>
	<jsp:include page="navigation.jsp">
		<jsp:param name="pageName" value="objects_manager"/>
	</jsp:include>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Gestion des oeuvres</h1>

<form id="add_object">
	  <div class="form-group">
	    <label for="title_f">Titre de l'objet</label>
	    <input type="text" class="form-control" id="title_f" name="title_f" placeholder="Entrer un titre">
	  </div>
	   <div class="form-group">
	    <label for="title_e">Titre de l'objet en anglais</label>
	    <input type="text" class="form-control" id="title_e" name="title_e" placeholder="Entrer un titre">
	  </div>
	  <div class="form-group">
	    <label for="description_f">Description de l'objet</label>
<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
	    <textarea class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet" rows="3"></textarea>
	  </div>
	  <div class="form-group">
	    <label for="description_e">Description de l'objet en anglais</label>
<!-- 	    <input type="text" class="form-control" id="description_f" name="description_f" placeholder="Entrer une description de l'objet"> -->
	    <textarea class="form-control" id="description_e" name="description_e" placeholder="Entrer une description de l'objet" rows="3"></textarea>
	  </div>
	  <div class="form-group">
	    <label for="reference">Réference de l'objet</label>
	    <input type="text" class="form-control" id="reference" name="reference" placeholder="Entrer la réference de l'objet si elle existe">
	  </div>
	  <div class="form-group">
	    <label for="country">Pays</label>
	    <input type="text" class="form-control" id="country" name="country" placeholder="Entrer le pays d'origine de l'objet">
	  </div>
	    <div class="form-group">
	    <label for="city">Ville</label>
	    <input type="text" class="form-control" id="city" name="city" placeholder="Entrer la ville d'origine de l'objet">
	  </div>
<!-- 	  <div class="form-group"> -->
<!-- 	  <label for="file1">Importer une photo : </label> <input type="file" size="60" -->
<!-- 			id="file1" name="upload" /> <br /> -->
<!-- 		<label for="file2">Importer une photo : </label> <input type="file" size="60" -->
<!-- 			id="file2" name="upload" /> <br /> -->
<!-- 		<label for="file3">Importer une photo : </label> <input type="file" size="60" -->
<!-- 			id="file3" name="upload" /> <br /> -->
<!-- 	  </div> -->
<!-- 	     <div class="form-group"> -->
<div class="form-group">
<div id = "imagesManager"></div>
	<!-- <button id="playButton">Play</button>
	<button id="pauseButton">Pause</button>
	<button id="getCurrentIndex">current</button> -->
	<br/><br/>
	<div id = "audiosManager"></div><br/><br/>
	<div id = "videosManager"></div>
	<div class="form-group">
	<label for="period">
	Sélectionner la période de l'objet
	</label>
			<s:select label="Sélectionner la periode de l'objet" 
	 		headerKey="-1" 
	 		list="listP"
	   		listKey="id"
	   		listValue="name"  
	 		name="period"
	 		id="period" 
 			value="defaultSearchEngine"
 			cssClass="form-control" />
 			
 			<label for="categories">
	Sélectionner les catégories
	</label>
 			<s:checkboxlist id="categories" label="" list="listCategory" listKey="id"
	   		listValue="name_f" name="categories"/>
 			
<!--  	<label for="category"> -->
<!-- 	Sélectionner la catégorie de l'objet -->
<!-- 	</label> -->
<%-- 			<s:select label="Sélectionner la periode de l'objet"  --%>
<%-- 	 		headerKey="-1"  --%>
<%-- 	 		list="listCategory" --%>
<%-- 	   		listKey="id" --%>
<%-- 	   		listValue="name_f"   --%>
<%-- 	 		name="category" --%>
<%-- 	 		id="category"  --%>
<%--  			value="defaultSearchEngine" --%>
<%--  			cssClass="form-control" />		 --%>
		
	     </div>
	     <input type="hidden" name="latitude" id="latitude" value="">
	  	 <input type="hidden" name="longitude" id="longitude" value="">

	<!-- 	  <button type="submit" class="btn btn-default" onclick="AddObjectAdmin()">Valider</button> -->
	  <div style="margin-left:0px;"><s:submit value="submit" name="submit" cssClass="btn btn-default"/></div>
	</form>

</s:if>
	
	<s:else>
		<script>
			window.location = '../admin/login.jsp';
		</script>			  
	</s:else>
<script>
// function beforeSubmit(){
	function progress(evt){
		if (evt.lengthComputable) {
	        var percentComplete = evt.loaded / evt.total;
	        console.log('progress ' + 100 * percentComplete + ' %');
	        //progressElem.html(Math.round(percentComplete * 100) + "%");
	    }
	    else{
	    	console.log('progress');	
	    }
	}
	var mediaManager = new MediaManager();
	$(function(){
		
		// for the images :
		var medias = [];
		var imagesCaroussel = new MediaCarousel(mediaManager, 'imagesManager', 'image', medias, false);
		
// 		// for the audio :
// 		medias = [];
// 		medias.push(new Media(mediaManager, "audio", "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a", "audio 1", "audio 1", 0));
// 		medias.push(new Media(mediaManager, "audio", "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a", "audio 2", "audio 2", 0));
// 		var imagesCaroussel = new MediaCarousel(mediaManager, 'audiosManager', 'audio', medias, false);
		
// 		// for the video :
// 		medias = [];
// 		medias.push(new Media(mediaManager, "video", "http://video-js.zencoder.com/oceans-clip.mp4", "video 1", "video 1", 0));
// 		medias.push(new Media(mediaManager, "video", "http://video-js.zencoder.com/oceans-clip.mp4", "video 2", "video 2", 0));
// 		var imagesCaroussel = new MediaCarousel(mediaManager, 'videosManager', 'video', medias, false);
		
		/*$('#pauseButton').click(function(){
			$('#imageMedia').carousel('pause');
		});
		$('#playButton').click(function(){
			$('#imageMedia').carousel('cycle');
		});
		$('#getCurrentIndex').click(function(){
			alert($('.active').index());
		});*/
		$('#save').click(function(){
			alert('sauvegarde');
			mediaManager.prepareToSave();
			var formData = new FormData2();
			formData.append('', mediaManager);
			formData.append('testParam', 'ren');
			formData.send('upload_file.action', function(){alert('ok');}, function(){console.log('error in send');}, progress);
		});
	});
function formSubmit(){ 
	$('#add_object').submit(function(event) {
	  //alert('Handler for .submit() called.');
	  AddObjectAdmin();
	  var lng=$("#longitude").val();
	  var lat = $('#latitude').val();
// 	  if(!(lng && lat)){
		  //alert("Fail");
		  event.preventDefault();
		  //alert("re-test");
		 
// 	  }
	});
}
formSubmit();

// }
</script>
</body>

</html>