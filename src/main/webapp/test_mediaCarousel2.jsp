<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<s:include value="loadScripts.jsp"></s:include>
	<!--  load media scripts -->
	<s:include value="mediaElementsRequired.jsp"></s:include>
	<link href="./soundmanager/360player.css" rel="stylesheet" type="text/css">
	<link href="./soundmanager/360player-visualization.css" rel="stylesheet" type="text/css">
	<script src="soundmanager/js/berniecode-animator.js"></script>
	<script src="soundmanager/js/soundmanager2.js"></script>
	<script src="soundmanager/js/360player.js"></script>
	<style type="text/css">
		.mediaManager{
			width: 500px;
			height: 500px;
		}
		.cursorDelete{
			z-index: 100;
			position: absolute;
			top: 0;
			right: 0;
		}
	</style>
<title>Museum</title>
</head>
<body>
	<!-- The jPlayer div must not be hidden. Keep it at the root of the body element to avoid any such problems. -->
	<div id = "imagesManager"></div><br/><br/>
	<div id = "audiosManager"></div><br/><br/>
	<div id = "videosManager"></div>
	<br/>
	<br/>
	<button id="save">enregistrer les modifications</button>

</body>
<script type="text/javascript" src="js/alert.js"></script>
<script type="text/javascript" src="js/FormData2.js"></script>
<script type="text/javascript" src="js/mediaManager.js"></script>
<script type="text/javascript">
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
	
	$(function(){
		var mediaManager = new MediaManager();
		// for the images :
		var medias = [];
		medias.push(new Media(mediaManager, "image", "img/bible.gif", "bible", "bible", 0));
		medias.push(new Media(mediaManager, "image", "img/carousel1.jpg", "bible", "bible", 0));
		medias.push(new Media(mediaManager, "image", "img/carousel2.jpg", "bible", "bible", 0));
		medias.push(new Media(mediaManager, "image", "img/bas-relief.jpg", "bible", "bible", 0));
		var imagesCaroussel = new MediaCarousel(mediaManager, 'imagesManager', 'image', medias, false);
		
		// for the audio :
		medias = [];
		medias.push(new Media(mediaManager, "audio", "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a", "audio 1", "audio 1", 0));
		medias.push(new Media(mediaManager, "audio", "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a", "audio 2", "audio 2", 0));
		var imagesCaroussel = new MediaCarousel(mediaManager, 'audiosManager', 'audio', medias, false);
		
		// for the video :
		medias = [];
		medias.push(new Media(mediaManager, "video", "http://video-js.zencoder.com/oceans-clip.mp4", "video 1", "video 1", 0));
		medias.push(new Media(mediaManager, "video", "http://video-js.zencoder.com/oceans-clip.mp4", "video 2", "video 2", 0));
		var imagesCaroussel = new MediaCarousel(mediaManager, 'videosManager', 'video', medias, false);
		
		$('#pauseButton').click(function(){
			$('#imageMedia').carousel('pause');
		});
		$('#playButton').click(function(){
			$('#imageMedia').carousel('cycle');
		});
		$('#getCurrentIndex').click(function(){
			alert($('.active').index());
		});
		$('#save').click(function(){
			alert('sauvegarde');
			mediaManager.prepareToSave();
			var formData = new FormData2();
			formData.append('', mediaManager);
			formData.append('testParam', 'ren');
			formData.send('upload_file.action', function(){alert('ok');}, function(){console.log('error in send');}, progress);
		});
	});
</script>
</html>