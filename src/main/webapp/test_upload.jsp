<!DOCTYPE html>
<html>
<head>
<title>Ajax File Upload with Progress Bar</title>
<!-- Include jQuery form & jQuery script file. -->
<script
	src="js/jquery.js"></script>
<script src="jquery.form.js"></script>
<script src="js/fileUploadScript.js"></script>
<!-- Include css styles here -->
<link href="css/fileUpload.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h3>Ajax File Upload with Progress Bar</h3>
	<form id="UploadForm" action="upload_file.action" method="post"
		enctype="multipart/form-data">
		<label for="file1">file 1 : </label> <input type="file" size="60"
			id="file1" name="upload" /> <br />
		<label for="file2">file 2 : </label> <input type="file" size="60"
			id="file2" name="upload" /> <br />
		<label for="file3">file 3 : </label> <input type="file" size="60"
			id="file3" name="upload" /> <br />
		<input type="submit" value="Ajax File Upload">
		<div id="progressbox">
			<div id="progressbar"></div>
			<div id="percent">0%</div>
		</div>
		<br />
		<div id="message"></div>
	</form>
</body>
</html>