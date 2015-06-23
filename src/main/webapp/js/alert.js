function createModal(modalId, modalBodyHtmlElement, alertStyle){
	// modal div :
	var modalDiv = $('<div></div>')[0];
	modalDiv.setAttribute('class', 'modal fade');
	if(alertStyle){
		$(modalDiv).addClass('modalAlert');
	}
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
	if(!alertStyle){
		var headerDiv = $('<div></div>')[0];
		$(contentDiv).append(headerDiv);
		headerDiv.setAttribute('class', 'modal-header');
		$(headerDiv).html('<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>');
	}
	// modal-body :
	var bodyDiv = $('<div></div>')[0];
	$(contentDiv).append(bodyDiv);
	bodyDiv.setAttribute('class', 'modal-body');
	var img = $('<img/>')[0];
	$(bodyDiv).append(modalBodyHtmlElement);
	return modalDiv;
}

function prettyAlert(modalId, yesCallBack, noCallBack){
	var $modal = $('#' + modalId).modal('show');
	function yes(){
		$modal.on('hidden.bs.modal', yesCallBack);
		$modal.modal('hide');
	}
	function no(){
		$modal.on('hidden.bs.modal', noCallBack);
		$modal.modal('hide');
	}
	// handle the keyup events :
	$(document).keyup(function(e){
		if(e.keyCode == 13){ // enter
			yes();
		}
		if(e.keyCode == 27){ // escape
			no();
		}
	});
	// handle click events :
	var $buttonYes = $modal.find("button[class*='yes']");
	var $buttonNo = $modal.find("button[class*='no']");
	$buttonYes.click(yes);
	$buttonNo.click(no);
}

function prettyAlert2(text, yesCallBack, noCallBack){
	var $modalBodyDiv = $('<p></p>');
	var $msg = $('<span></span>');
	$msg.addClass('msg');
	$msg.html(text + '<br/></br>');
	$modalBodyDiv.append($msg[0]);
	$yesButton = $('<button type="button" class="yes btn btn-primary">Oui</button>');
	$noButton = $('<button type="button" class="no btn btn-primary">Non</button>');
	$modalBodyDiv.append($yesButton[0]);
	$modalBodyDiv.append($noButton[0]);
	var $modal = $(createModal('', $modalBodyDiv[0], true)).modal('show');
	function yes(){
		$modal.on('hidden.bs.modal', yesCallBack);
		$modal.modal('hide');
	}
	function no(){
		$modal.on('hidden.bs.modal', noCallBack);
		$modal.modal('hide');
	}
	// handle the keyup events :
	$(document).keyup(function(e){
		if(e.keyCode == 13){ // enter
			yes();
		}
		if(e.keyCode == 27){ // escape
			no();
		}
	});
	// handle click events :
	var $buttonYes = $modal.find("button[class*='yes']");
	var $buttonNo = $modal.find("button[class*='no']");
	$buttonYes.click(yes);
	$buttonNo.click(no);
}