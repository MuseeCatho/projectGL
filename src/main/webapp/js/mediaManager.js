function MediaManager(){
	this.medias = [];
	this.mediasToAdd = [];
	this.mediasToDelete = [];
}

MediaManager.prototype = {
		prepareToSave : function(){
			// update mediasToAdd and mediasToDelete
			this.mediasToAdd = [];
			this.mediasToDelete= [];
			for(var i = 0; i < this.medias.length; i ++){
				var media = this.medias[i];
				if(media.addIt && media.file != null){
					this.mediasToAdd.push(media);
				}
				else if(media.deleteIt && media.id != null){
					this.mediasToDelete.push(media);
				}
			}
		}
}

function MediaCarousel(mediaManager, divId, type, medias, canModify){
	this.mediaManager = mediaManager;
	this.type = type;
	if(type == 'image'){
		this.allowedFileTypes = [ 'png', 'jpg', 'jpeg', 'gif' ];
	}
	else if(type == 'audio'){
		this.allowedFileTypes = [];
	}
	else if(type == 'video'){
		this.allowedFileTypes = [];
	}
	else{
		this.allowedFileTypes = [];
	}
	this.divId = divId;
	this.medias = [];
	this.canModify = canModify; // boolean
	if(medias != null && medias != undefined){
		this.medias = medias;
	}
	// updating of the HTML block :
	$block = $('#' + divId);
	$block.addClass('mediaManager');
	$block.html('');
	$block.append(this.makeCarouselHtmlElement());
	$block.append(this.makeMediaListHtmlElement());
	$block.append(this.makeAddMediaButton())
	this.block = $block[0];
	return this.block;
}

MediaCarousel.prototype = {
		add: function(media, modalId, active){
			var item = $('<div></div>')[0];
			var itemClass = "item";
			if(active){
				itemClass += " active";
			}
			item.setAttribute('class', itemClass);
			// code for the media :
			var mediaCarouselItem = $('<div></div>')[0];
			$(item).append(mediaCarouselItem);
			$(item).append($('<div class="carousel-caption">' + media.alt + '</div>'));
			this.$carouselInner.append(item);
			mediaCarouselItem.setAttribute('class', 'mediaCarousel_item');
			if(media.type == 'image'){
				var img = media.getHtmlElement().cloneNode(true);
				img.setAttribute('data-toggle', 'modal');
				img.setAttribute('data-target', '#' + modalId);
				$(mediaCarouselItem).append(img);
				$('body').append(media.makeModalHtmlElement(modalId));
			}
			else if(media.type == 'audio'){
				var audioContainer = $('<div></div>')[0];
				audioContainer.setAttribute('class', 'audioContainer');
				$(audioContainer).append(media.getHtmlElement().cloneNode(true));
				$(mediaCarouselItem).append(audioContainer);
			}
			else if(media.type == 'video'){
				var videoContainer = $('<div></div>')[0];
				videoContainer.setAttribute('class', 'video-jsContainer');
				var width = $(item).width();
				var height = $(item).height();
				$(videoContainer).append(media.getHtmlElement(width, height).cloneNode(true));
				$(mediaCarouselItem).append(videoContainer);
			}
		},
		makeCarouselHtmlElement: function(){
			var carousel = $('<div></div>')[0];
			carousel.id = this.divId + 'Carousel';
			carousel.setAttribute('class', 'mediaCarousel carousel slide');
			carousel.setAttribute('data-ride', 'carousel');
			// carousel-indicators
			var ol = $('<ol></ol>')[0];
			ol.setAttribute('class', 'carousel-indicators');
			var $ol = $(ol);
			for (var i = 0; i < this.medias.length; i++) {
				var li = $('<li></li>')[0];
				li.setAttribute('data-target', '#' + this.divId);
				li.setAttribute('data-slide-to', i);
				if(i == 0){
					li.setAttribute('class', 'active');
				}
				$ol.append(li);
			}
			$(carousel).append(ol);
			// carousel-inner
			var carouselInner = $('<div></div>')[0];
			carouselInner.setAttribute('class', 'carousel-inner');
			this.$carouselInner = $(carouselInner);
			for (var i = 0; i < this.medias.length; i++) {
				var active = false;
				if(i == 0){
					active = true;
				}
				this.add(this.medias[i], 'imageMediaModal' + i, active);
			}
			var $carousel = $(carousel);
			$carousel.append(carouselInner);
			//$block.append(carouselInner);
			// set previous and next button :
			var a = $('<a></a>')[0];
			a.setAttribute('class', 'left carousel-control');
			a.setAttribute('href', '#' + this.divId + 'Carousel');
			a.setAttribute('role', 'button');
			a.setAttribute('data-slide', 'prev');
			$(a).html('<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span>');
			$carousel.append(a);
			a = a.cloneNode(false);
			a.setAttribute('class', 'carousel-control right');
			a.setAttribute('data-slide', 'next');
			$(a).html('<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span>');
			$carousel.append(a);
			$carousel.carousel({interval : 3000});
			$carousel.click(function(){
				$carousel.carousel('pause');
			});
			return carousel
		},
		makeMediaListHtmlElement: function(){
			var $mediaListDiv = $('<div></div>');
			return $mediaListDiv[0];
		},
		makeAddMediaButton: function(){
			// make addMediaDiv :
			var $addMediaDiv = $('<div></div>');
			$addMediaDiv.addClass('addButton col-md-4');
			var $addMediaInput = $('<input/>');
			$addMediaInput[0].setAttribute('class', 'btn btn-primary navbar-btn');
			$addMediaInput[0].setAttribute('role', 'file');
			var mediaDescription = ''
			if(this.type == 'image'){
				mediaDescription = 'une image';
			}
			else if(this.type == 'audio'){
				mediaDescription = 'un audio';
			}
			else if(this.type == 'video'){
				mediaDescription = 'une vidéo';
			}
			else{
				mediaDescription = 'un média';
			}
			var buttonValue = 'Ajouter ' + mediaDescription;
			$addMediaInput[0].setAttribute('value', buttonValue);
			$addMediaInput[0].setAttribute('data-toggle', 'modal');
			$addMediaInput[0].setAttribute('data-target', '#' + this.divId + 'AddMediaModal');
			$addMediaDiv.append($addMediaInput[0]);
			// make addFileDiv :
			$addFileDiv = $($addMediaDiv[0].cloneNode(false));
			$addFileDiv[0].setAttribute('style', 'display: inline;');
			$addFileInput1 = $($addMediaInput[0].cloneNode(false));
			$addFileInput1[0].setAttribute('onclick', '$(\'#' + this.divId + 'AddFile' + '\').click();');
			// treat the file input :
			var $addFileInput2 = $('<input/>');
			$addFileInput2[0].setAttribute('class', 'btn btn-primary navbar-btn');
			$addFileInput2[0].setAttribute('role', 'file');
			$addFileInput2[0].setAttribute('style','display: none');
			$addFileInput2[0].setAttribute('type','file');
			$addFileInput2[0].setAttribute('id', this.divId + 'AddFile');
			$addFileInput2[0].setAttribute('name', 'upload');
			var objRef = this;
			$addFileInput2.change(function(evt){
				var file = evt.target.files[0];
				var fileName = file.name;
				var extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
				if (objRef.allowedFileTypes.indexOf(extension) != -1) {
					// create a Media instance
					var media = new Media(objRef.mediaManager, objRef.type, file, '', '', null);
					media.addIt = true;
					objRef.createThumbnail(media);
				}
				else{
					console.log('error file type');
				}
			});
			$addFileDiv.append($addFileInput1[0]);
			$addFileDiv.append($addFileInput2[0]);
			var $p = $('<p></p>');
			var htmlCode = '<strong>Pour ajouter ' + mediaDescription + ':</strong><br/><br/>';
			htmlCode += 'entrez l\'url d\'' + mediaDescription + ' : <input style="display:inline;" type="text" class="form-control" id="name" placeholder="Enter Name">';
			htmlCode += '<br/><br/>ou<br/><br/>importez ' + mediaDescription + ' depuis votre ordinateur :';
			$p.html(htmlCode);
			$p.append($addFileDiv[0]);
			$('body').append(createModal(this.divId + 'AddMediaModal', $p[0]));
			return $addMediaDiv[0];
		},
		createThumbnail: function(media) {
			var mediaDiv = media.getHtmlElement();
			$('body').append(mediaDiv);
			alert(mediaDiv.innerHTML);
		}
}

function Media(mediaManager, type, srcOrFile, alt, title, id){
	this.number ++;
	mediaManager.medias.push(this);
	this.type = type;
	this.id = id;
	this.src = "";
	this.alt = alt;
	this.title = title;
	if(typeof srcOrFile == 'string'){
		this.src = srcOrFile;
	}
	else{
		this.file = srcOrFile;
	}
	this.addIt = false;
	this.deleteIt = false;
	this.block = null;
}

Media.prototype = {
		getHtmlElement : function(width, height){
			var obj = this;
			if(this.block == null){
				if(this.type == 'image'){
					this.block = $('<img/>')[0];
					this.loadMedia(this.block, 'src');
				}
				else if(this.type == 'audio'){
					this.block = $('<div></div>')[0];
					this.block.setAttribute('class', 'ui360 ui360-vis');
					var a = $('<a></a>')[0];
					$(this.block).append(a);
					this.loadMedia(a, 'href');
				}
				else if(this.type == 'video'){
					this.block = $('<video></video>')[0];
					//this.block.id = "video" + this.number;
					this.block.setAttribute('class', 'video-js vjs-default-skin');
					this.block.setAttribute('controls', true);
					this.block.setAttribute('preload', 'auto');
					/*this.block.setAttribute('width', 500);
					this.block.setAttribute('height', 300);*/
					this.block.setAttribute('poster', 'http://video-js.zencoder.com/oceans-clip.png');
					this.block.setAttribute('data-setup', {"example_option": true});
					var source = $('<source/>')[0];
					source.setAttribute('type', 'video/mp4');
					$(this.block).append(source);
					var p = $('<p></p>')[0];
					p.setAttribute('class', 'vjs-no-js');
					$(p).html('To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>');
					$(this.block).append(p);
					this.loadMedia(source, 'src');
				}
				this.block.alt = this.alt;
				this.block.title = this.title;
			}
			return this.block;
		},
		loadMedia: function(blockSrc, attributeName){
			if(this.src != "" && this.src != null){
				blockSrc[attributeName] = this.src;
			}
			else if(this.file != null){
				// load the media (asynchrone)
				var reader = new FileReader();
				reader.addEventListener("load", function(){
					blockSrc[attributeName] = this.result;
				});
				reader.readAsDataURL(this.file);
			}
			else{
				console.log('media error');
			}
		},
		number : 0,
		makeModalHtmlElement: function(modalId){
			// modal div :
			var modalDiv = $('<div></div>')[0];
			modalDiv.setAttribute('class', 'modal fade');
			modalDiv.setAttribute('id', modalId);
			modalDiv.setAttribute('tabindex', '-1');
			modalDiv.setAttribute('role', 'dialog');
			modalDiv.setAttribute('aria-labelledby', 'myModalLabel');
			modalDiv.setAttribute('aria-hidden', 'true');
			// modal dialog :
			var dialogDiv = $('<div></div>')[0];
			$(modalDiv).append(dialogDiv);
			dialogDiv.setAttribute('class', 'mediaModal modal-dialog');
			// modal content :
			var contentDiv = $('<div></div>')[0];
			$(dialogDiv).append(contentDiv);
			contentDiv.setAttribute('class', 'modal-content');
			// modal-header :
			var headerDiv = $('<div></div>')[0];
			$(contentDiv).append(headerDiv);
			headerDiv.setAttribute('class', 'modal-header');
			$(headerDiv).html('<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>');
			// modal-body :
			var bodyDiv = $('<div></div>')[0];
			$(contentDiv).append(bodyDiv);
			bodyDiv.setAttribute('class', 'modal-body');
			var img = $('<img/>')[0];
			$(bodyDiv).append(img);
			this.loadMedia(img, 'src');
			return modalDiv;
		}
};