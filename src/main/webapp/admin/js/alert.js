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