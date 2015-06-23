function FormData2(){
	var objRef = this;
	this.originalFormData = new FormData;
}

FormData2.prototype = {
	append : function(name, obj){
		if(obj instanceof File){
			this.originalFormData.append(name, obj);
			console.log('add ' + name + ' fileName : ' + obj.name);
		}
		else if(obj instanceof MediaManager){
			// add medias :
			console.log('obj.mediaToAdd.lenght : ' + obj.mediasToAdd.length);
			for(var i = 0; i < obj.mediasToAdd.length; i ++){
				console.log('renFinal');
				this.append('upload', obj.mediasToAdd[i].file);
			}
			// delete medias :
			var mediasToDelete = [];
			for(var i = 0; i < obj.mediasToDelete; i ++){
				mediasToDelete.push(obj.mediasToDelete[i].id);
			}
			this.append('mediasToDelete', mediasToDelete.toString());
		}
		else{
			this.originalFormData.append(name, obj);
			console.log('add ' + name + ' obj : ' + obj);
		}
	},
	send : function(actionName, success, error, progress){
		var objRef = this;
		jqxhr = $.ajax({
	        url: actionName,
	        type: 'POST',
			encoding : "UTF-8",
			encryption : "multipart/form-data",
	        data: objRef.originalFormData,
	        cache: false,
	        processData: false, // Don't process the files
	        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
	        xhr: function () {
	            var xhr = new window.XMLHttpRequest();
	            xhr.upload.onprogress = progress
	            return xhr;
	        },
	        success: success,
	        error: error
	    });
	},
	get : function(name){
		return typeof this[name] != 'undefined' ? this[name] : this.originalFormData[name];
	},
	set : function(name, value){
		if(typeof this[name] != 'undefined'){
			this[name] = value;
		}
		else{
			this.originalFormData[name] = value;
		}
	}
};