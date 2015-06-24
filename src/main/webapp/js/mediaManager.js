function MediaManager(){
	this.medias = [];
	this.mediasToAdd = [];
	this.mediasToDelete = [];
	this.mediasToDeleteType = [];
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
					this.mediasToDeleteType.push(media.type);
				}
			}
		}
}

function MediaCarousel(mediaManager, divId, type, medias, canModify){
	this.id = divId + 'Carousel';
	this.mediaManager = mediaManager;
	this.type = type;
	if(type == 'image'){
		this.allowedFileTypes = [ 'png', 'jpg', 'jpeg', 'gif', 'mp4', 'mp3' ];
	}
	else if(type == 'audio'){
		this.allowedFileTypes = ['mp3', 'm4a'];
	}
	else if(type == 'video'){
		this.allowedFileTypes = ['mp4', 'mp3', 'm4a'];
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
	var $block = $('#' + divId);
	this.block = $block[0];
	$block.addClass('mediaManager');
	$block.html('');
	// make the carousel :
	this.carousel = this.createCarouselHtmlElement();
	this.lisIndicators = [];
	this.carouselIndicators = this.createCarouselIndicatorsHtmlElement();
	this.nextDataSlideTo = 0;
	this.itemsInner = [];
	this.carouselInner = this.createCarouselInnerHtmlElement();
	this.makeCarouselHtmlElement(); // empty and fill (rebuild) the carousel
	// make the alertBlock :
	this.$alertHtmlElement = $('<div></div>');
	this.$alertHtmlElement[0].id = this.divId + 'alertBlock';
	//alert(this.carouselIndicators.innerHTML);
	$block.append(this.carousel);
	$block.append(this.makeMediaListHtmlElement());
	$block.append(this.makeAddMediaButton());
	//$block.append(this.$alertHtmlElement[0]);
	return this.block;
}

MediaCarousel.prototype = {
		addMedia: function(media, modalId, active, afterLoad){
			var objRef = this;
			function createDeleteButton(media, dataSlideTo){
				/*var $button = $('<div class="cursor_delete"></div>');
				$button[0].setAttribute('onclick', 'alert("delete")');
				var $img = $('<img alt="alternativtext" class="icon icon_cancel" src="img/icon/cancel.png" width="30" height="30">');
				$button.append($img);
				return $button[0];*/
				var $button = $('<div style="position:absolute;top:0px;right:0px;z-index:100;width:50px;height:50px;"><img style="width:100%;height:100%;" src="img/icon/cancel.png"/></div>');
				$button.click(function(){
					if(media.file != null){
						media.addIt = false;
						objRef.deleteMedia(dataSlideTo);
					}
					else{
						media.addIt = false;
						media.deleteIt = true;
						$(media.block).css({opacity: 0.3});
						$(this).css({display: 'none'});
					}
				});
				return $button[0];
			}
			function updateMediaCarouselItem(mediaCarouselItem, media){
				if(media.type == 'image'){
					var img = media.getHtmlElement();
					img.setAttribute('data-toggle', 'modal');
					img.setAttribute('data-target', '#' + modalId);
					$(mediaCarouselItem).append(img);
					$('body').append(media.makeModalHtmlElement(modalId));
				}
				else if(media.type == 'audio'){
					var audioContainer = $('<div></div>')[0];
					audioContainer.setAttribute('class', 'audioContainer');
					$(audioContainer).append(media.getHtmlElement());
					$(mediaCarouselItem).append(audioContainer);
					console.log('ren0');
				}
				else if(media.type == 'video'){
					var videoContainer = $('<div></div>')[0];
					videoContainer.setAttribute('class', 'video-jsContainer');
					/*var width = $item.width();
					var height = $item.height();*/
					videoContainer.afterLoad = function(){
						
					};
					$(videoContainer).append(media.getHtmlElement());
					$(mediaCarouselItem).append(videoContainer);
				}
			}
			// create the media
			// li to add to the carousel-indicators div :
			var li = $('<li></li>')[0];
			li.setAttribute('data-target', '#' + this.id);
			li.setAttribute('data-slide-to', this.nextDataSlideTo);
			this.nextDataSlideTo ++;
			if(active){
				li.setAttribute('class', 'active');
			}
			$(this.carouselIndicators).append(li);
			this.lisIndicators.push(li);
			
			// item to add to the carousel-inner div :
			var $item = $('<div></div>');
			$item.addClass('item');
			if(active){
				$item.addClass('active');
			}
			// code for the media :
			var mediaCarouselItem = $('<div></div>')[0];
			$item.append(mediaCarouselItem);
			// $item.append(createDeleteButton());
			//$(mediaCarouselItem).append(createDeleteButton());
			$item.append($('<div class="carousel-caption">' + media.alt + '</div>'));
			$(this.carouselInner).append($item[0]);
			this.itemsInner.push($item[0]);
			mediaCarouselItem.setAttribute('class', 'mediaCarousel_item');
			updateMediaCarouselItem(mediaCarouselItem, media);
			$(mediaCarouselItem).append(createDeleteButton(media, this.nextDataSlideTo - 1));
		},
		deleteMedia: function(dataSlideTo){
			console.log('call deleteMedia');
			for(var i = dataSlideTo + 1; i < this.lisIndicators.length; i ++){
				this.lisIndicators[i].setAttribute('data-slide-to', i - 1);
			}
			this.itemsInner[dataSlideTo].parentNode.removeChild(this.itemsInner[dataSlideTo]);
			this.itemsInner.slice(dataSlideTo, 1);
			this.lisIndicators[dataSlideTo].parentNode.removeChild(this.lisIndicators[dataSlideTo]);
			this.lisIndicators.slice(dataSlideTo, 1);
			$(this.lisIndicators[0]).addClass('active');
			$(this.itemsInner[0]).addClass('active');
			$(this.carousel).carousel(0);
		},
		createCarouselHtmlElement: function(){
			var carousel = $('<div></div>')[0];
			carousel.id = this.id;
			carousel.setAttribute('class', 'mediaCarousel carousel slide');
			carousel.setAttribute('data-ride', 'carousel');
			// carousel-indicators
			return carousel;
		},
		createCarouselIndicatorsHtmlElement: function(){
			var ol = $('<ol></ol>')[0];
			ol.setAttribute('class', 'carousel-indicators');
			var $ol = $(ol);
			return $ol;
		},
		createCarouselInnerHtmlElement: function(){
			var carouselInner = $('<div></div>')[0];
			carouselInner.setAttribute('class', 'carousel-inner');
			return carouselInner;
		},
		makeCarouselHtmlElement: function(){
			// call the addMedia method :
			var objRef = this;
			var $carousel = $(this.carousel).html('');
			$carousel[0].id = this.id;
			$carousel[0].setAttribute('class', 'mediaCarousel carousel slide');
			$carousel[0].setAttribute('data-ride', 'carousel');
			// insert carousel-indicators and carousel-inner :
			$carousel.append(this.carouselIndicators);
			$carousel.append(this.carouselInner);
			for (var i = 0; i < this.medias.length; i++) {
				var active = false;
				if(i == 0){
					active = true;
				}
				this.medias[i].loadMedia(function(){ // sync
					objRef.addMedia(objRef.medias[i], objRef.divId + 'ImageMediaModal' + i, active);
				});
			}
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
		},
		makeMediaListHtmlElement: function(){
			// code of Amandine :
			var $mediaListDiv = $('<div></div>');
			return $mediaListDiv[0];
		},
		makeAddMediaButton: function(){
			var objRef = this;
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
			$addFileDiv.append($addFileInput1[0]);
			$addFileDiv.append($addFileInput2[0]);
			var $p = $('<p></p>');
			var htmlCode = '<strong>Pour ajouter ' + mediaDescription + ':</strong><br/><br/>';
			htmlCode += 'entrez l\'url d\'' + mediaDescription + ' : <input style="display:inline;" type="text" class="form-control" id="' + this.id + 'InputAddUrl' + '" placeholder="Enter Name">';
			htmlCode += '<button id="' + this.id + 'OkButton' + '">Ok</button>';
			htmlCode += '<br/><br/>ou<br/><br/>importez ' + mediaDescription + ' depuis votre ordinateur :';
			$p.html(htmlCode);
			$p.append($addFileDiv[0]);
			this.addMediaModal = createModal(this.divId + 'AddMediaModal', $p[0]);
			$('body').append(this.addMediaModal);
			
			// events for create media :
			$addFileInput2.change(function(evt){
				var file = evt.target.files[0];
				objRef.treatAddMediaInputs(file);
			});
			$('#' + this.id + 'OkButton').click(function(){
				//imagesManagerCarouselInputAddUrl
				//alert(objRef.id + 'InputAddUrl');
				var src = $('#' + objRef.id + 'InputAddUrl').val();
				objRef.treatAddMediaInputs(src);
			});
			return $addMediaDiv[0];
		},
		treatAddMediaInputs: function(srcOrFile){
			var objRef = this;
			// create the media and add it to the carousel :
			function stringToExtension(str){
				return str.substring(str.lastIndexOf('.') + 1).toLowerCase();
			}
			var extension = '';
			if(typeof srcOrFile == 'string'){
				extension = stringToExtension(srcOrFile);
			}
			else{
				extension = stringToExtension(srcOrFile.name);
			}
			if (objRef.allowedFileTypes.indexOf(extension) != -1) {
				// create a Media instance
				var media = new Media(objRef.mediaManager, objRef.type, srcOrFile, '', '', null);
				media.addIt = true;
				// addMedia after load :
				media.loadMedia(function(){ // async
					objRef.addMedia(media, objRef.id + 'ImageMediaModal' + objRef.nextDataSlideTo, false);
					objRef.deleteAlert();
					$(objRef.carousel).carousel('pause');
					$(objRef.carousel).carousel(this.nextDataSlideTo - 1);
				});
				// update the alert block :
				this.addAlert('alert-info', 'chargement du média en cours ...');
				//var mediaHtmlElement = media.getHtmlElement();
				/*media.loadEvent = function(){
					objRef.deleteAlert();
				};*/
				$(media.blockSrc).error(function(){
					objRef.addAlert('alert-danger', 'le média n\'a pas été trouvé !');
				});
				this.createThumbnail(media);
			}
			else{
				this.addAlert('alert-danger', 'le média n\'a pas le type approprié');
			}
			$(this.addMediaModal).modal('hide');
		},
		addAlert: function(alertClass, txt){
			this.deleteAlert();
			this.$alertHtmlElement[0].setAttribute('class', '');
			this.$alertHtmlElement.addClass('alert ' + alertClass);
			this.$alertHtmlElement.html(txt);
			$(this.block).append(this.$alertHtmlElement[0]);
		},
		deleteAlert: function(){
			var parentDiv = this.$alertHtmlElement[0].parentNode;
			if(parentDiv != null){
				parentDiv.removeChild(this.$alertHtmlElement[0]);
			}
		},
		createThumbnail: function(media) {
			if(media.type == 'video'){
				
			}
			//alert(mediaDiv.innerHTML);
		}
}

function Media(mediaManager, type, srcOrFile, alt, title, id){
	this.alreadyLoad;
	//this.number ++;
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
	this.loadEvent = function(){
		
	};
	this.afterLoad = function(){
		
	}
}

Media.prototype = {
		getHtmlElement: function(){
			// loadTheMedia
			var obj = this;
			if(this.block == null){
				if(this.type == 'image'){
					this.block = $('<img src = "' + this.src + '"/>')[0];
				}
				else if(this.type == 'audio'){
					this.block = $('<div></div>')[0];
					this.block.setAttribute('class', 'ui360 ui360-vis');
					this.blockSrc = $('<a></a>')[0];
					$(this.block).append(this.blockSrc);
					this.blockSrc.setAttribute('href', this.src);
				}
				else if(this.type == 'video'){
					//var video = $('<video controls><source src="' + objRef.blockSrc.src + '" type="video/mp4"/>Your browser does not support the video tag.</video>');
					/*this.block = $('<video></video>')[0];
					//this.block.id = "video" + this.number;
					this.block.setAttribute('class', 'video-js vjs-default-skin');
					this.block.setAttribute('controls', true);
					this.block.setAttribute('preload', 'auto');
					this.block.setAttribute('poster', 'http://video-js.zencoder.com/oceans-clip.png');
					this.block.setAttribute('data-setup', {"example_option": true});
					var source = $('<source/>')[0];
					this.blockSrc = source;
					source.setAttribute('type', 'video/mp4');
					$(this.block).append(source);
					var p = $('<p></p>')[0];
					p.setAttribute('class', 'vjs-no-js');
					$(p).html('To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>');
					$(this.block).append(p);*/
					this.block = $('<video controls></video>')[0];
					var source = $('<source/>')[0];
					this.blockSrc = source;
					source.setAttribute('type', 'video/mp4');
					$(this.block).append(source);
					this.blockSrc.src = this.src;
				}
				this.block.alt = this.alt;
				this.block.title = this.title;
			}
			return this.block;
		},
		loadMedia: function(cb){
			if(! this.alreadyLoad){
				this.alreadyLoad = true;
				var objRef = this;
				if(this.src != "" && this.src != null){
					cb();
				}
				else if(this.file != null){
					// load the media (asynchrone)
					var reader = new FileReader();
					reader.addEventListener("load", function(){
						objRef.src = this.result;
						cb();
					});
					reader.readAsDataURL(this.file);
				}
				else{
					console.log('media error');
				}
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
			//var img = $('<img/>')[0];
			$(bodyDiv).append(this.block.cloneNode(false));
			//
			return modalDiv;
		}
};