<!DOCTYPE html>
<html>
<head>
<title>Ajax File Upload with Progress Bar</title>
<!-- Include jQuery form & jQuery script file. -->
<script src="js/jquery.js"></script>
<!-- Include css styles here -->
<link href="css/fileUpload.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h3>Ajax File Upload with Progress Bar</h3>
	<input type="file" size="60" id="file1" name="upload" />
	<button>update</button>
	<div id="imgs"></div>
</body>
<script type="text/javascript" src="js/mediaManager.js"></script>
<script>
var mediaManager = new MediaManager();
var media = new Media(mediaManager, 'image', 'img/bible.gif');
media.getHtmlElement();
mediaManager.push(media);
$(function(){
	$('#file1').change(function(e){
		var media = new Media(mediaManager, 'image', e.target.files[0]);
		media.getHtmlElement();
		mediaManager.push(media);
	});
	
	$('button').click(function(){
		$imgs = $('#imgs');
		$imgs.html('');
		for(var i = 0; i < mediaManager.length; i ++){
			$imgs.append(mediaManager[i].block);
		}
		console.log('finish');
	});
});
</script>
</html>