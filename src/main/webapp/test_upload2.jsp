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
	<button>upload</button>
</body>
<script>
	var files = [];
	$(function(){
		
		(function addXhrProgressEvent($) {
		    var originalXhr = $.ajaxSettings.xhr;
		    $.ajaxSetup({
		        progress: function() { console.log("standard progress callback"); },
		        xhr: function() {
		            var req = originalXhr(), that = this;
		            if (req) {
		                if (typeof req.addEventListener == "function") {
		                    req.addEventListener("progress", function(evt) {
		                        that.progress(evt);
		                    },false);
		                }
		            }
		            return req;
		        }
		    });
		})(jQuery);
		
		$('#file1').change(function(e){
			//console.log(this.files[0].name);
			/*var reader = new FileReader();
			reader.addEventListener('load', function() {
				console.log(this.result.length);
			}, false);
			reader.readAsDataURL(this.files[0]);*/
			files.push(e.target.files[0]);
		});
		
		$('button').click(function(){
			console.log('uploading ...');
			var formData = new FormData();
		   	for (var i = 0; i < files.length; i++) {
			   	  var file = files[i];
	
			   	  // Add the file to the request.
			   	  formData.append('upload', file/*, file.name*/);
			   	  console.log('typeof(file) : '+ (file instanceof File));
		   	}
		   	formData.append('testParam', 'ren');
			console.log("ren1");

			jqxhr = $.ajax({
		        url: 'upload_file.action',
		        type: 'POST',
				encoding : "UTF-8",
				encryption : "multipart/form-data",
		        data: formData,
		        cache: false,
		        processData: false, // Don't process the files
		        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
		        xhr: function () {
		            var xhr = new window.XMLHttpRequest();
		            //Download progress
		            xhr.upload.onprogress = function(evt){
		            	if (evt.lengthComputable) {
		                    var percentComplete = evt.loaded / evt.total;
		                    console.log('progress ' + 100 * percentComplete + ' %');
		                    //progressElem.html(Math.round(percentComplete * 100) + "%");
		                }
		                else{
		                	console.log('progress');	
		                }
		            };
		            return xhr;
		        },
		        success: function(data, textStatus, jqXHR)
		        {
		        	alert("ok");
		            if(typeof data.error === 'undefined')
		            {
		                // Success so call function to process the form
		                /*submitForm(event, data);*/
		            }
		            else
		            {
		                // Handle errors here
		                console.log('ERRORS: ' + data.error);
		            }
		        },
		        error: function(jqXHR, textStatus, errorThrown){
		        	alert("ranas");
		            // Handle errors here
		            console.log('ERRORS: ' + textStatus);
		            // STOP LOADING SPINNER
		        }
		    });
			
			console.log("finish");
		});
	});
</script>
</html>