function UsersData(){
	/* this class include all the users */
	this.ban = 0;
	this.admin = 0;
	this.searchString = "";
	this.pageNumber = 1;
	//this.numberUsers = 0;
	this.observer = null;
	this.id = 0;
	this.objectForSearch =  {id : this.id, admin : this.admin, searchString : this.searchString, pageNumber : this.pageNumber, ban : this.ban};
}

UsersData.prototype = {
		search : function(){ // use the attributes admin, searchString and pageNumber
			//this.observer.loading();
			this.updateObjectForSearch();
			console.log("search : " + this.searchString + ", admin : " + this.admin);
			var usersDataRef = this;
			var actionName = "searchUsers.action";
			// get the data with ajax :
			this.callAction(actionName, this.objectForSearch);
		},

		permuteAdmin : function(id){
			//this.observer.updateUsers();
			this.id = id;
			this.updateObjectForSearch();
			console.log("permit admin : " + id);
			var actionName = "permuteAdmin.action";
			this.callAction(actionName, this.objectForSearch);
		},

		permuteBan : function(id){
			//this.observer.updateUsers();
			this.id = id;
			this.updateObjectForSearch();
			console.log("permit ban : " + id);
			var actionName = "permuteBan.action";
			this.callAction(actionName, this.objectForSearch);
		},

		deleteUser : function(id){
			//this.observer.updateUsers();
			this.id = id;
			this.updateObjectForSearch();
			console.log("delete admin : " + id);
			var actionName = "deleteUser.action";
			this.callAction(actionName, this.objectForSearch);
		},

		callAction : function(actionName, objectToSend){
			var usersDataRef = this;
			// get the data with ajax :
			console.log('objectToSend : ' + JSON.stringify(objectToSend));
			var jqxhr = $.post(actionName, objectToSend);
			jqxhr.done(function(data){
				if(usersDataRef.observer != null){
					usersDataRef.observer.update(data);
				}
			});
			jqxhr.fail(function(){
				usersDataRef.observer.fail();
				console.log('fail');
			});
		},
		
		updateObjectForSearch : function(){
			this.objectForSearch =  {id : this.id, admin : this.admin, searchString : this.searchString, pageNumber : this.pageNumber, ban : this.ban};
		}
};

function UsersObserver(usersData){
	usersData.observer = this;
	this.usersDiv = $("#usersDiv");
	//this.pagesDiv = $("#pageDiv");
}

UsersObserver.prototype = {
		update : function(usersDataHTML){
			this.usersDiv.html(usersDataHTML);
		},

		loading : function(){
			var HTMLCode = this.generateMessage(language, "info", "Chargement des données ...", "Loading ...");
			this.usersDiv.html(HTMLCode);
		},

		updateUsers : function(){
			var HTMLCode = this.generateMessage(language, "info", "Modification des données ...", "Loading ...");
			this.usersDiv.html(HTMLCode);
		},

		fail : function(){
			var HTMLCode = this.generateMessage(language, "danger", "Une erreur est survenue. Veuillez réessayer ultérieurement.", "An error occur. Please retry later.");
			this.usersDiv.html(HTMLCode);
		},
		
		generateMessage : function(language, alertType, frenchMessage, englishMessage){
			var HTMLCode = '<br/><br/><div class="alert alert-' + alertType + '">';
			if(language == 'french'){
				HTMLCode += frenchMessage;
			}
			else{
				HTMLCode += englishMessage;
			}
			HTMLCode += '</div>';
			return HTMLCode;
		}
};

var usersData = new UsersData();
var usersObserver = new UsersObserver(usersData);

//event :

$('#searchInput').keyup(function(e){
	usersData.pageNumber = 1;
	usersData.searchString = $(this).val();
	console.log('search: ' + $(this).val());
	usersData.search();
});

$('#adminInput').change(function(){
	usersData.pageNumber = 1;
	usersData.admin = $(this).val();
	usersData.search();
});

$('#banInput').change(function(){
	usersData.pageNumber = 1;
	usersData.ban = $(this).val();
	usersData.search();
});
//start search
usersData.search();