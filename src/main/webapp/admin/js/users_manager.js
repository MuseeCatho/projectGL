function UsersData(){
	/* this class include all the users */
	this.admin = 1;
	this.searchString = "";
	this.pageNumber = 1;
	this.numberUsers = 0;
	this.observer = null;
}

UsersData.prototype = {
		search : function(){ // use the attributes admin, searchString and pageNumber
			this.observer.loading();
			console.log("search : " + searchString + ", admin : " + admin)
			var usersDataRef = this;
			// get the data with ajax :
			var jqxhr = $.post('http://localhost:8080/musee_catho/admin/searchUsers.action', {admin : usersDataRef.admin, searchString : usersDataRef.searchString, pageNumber : usersDataRef.pageNumber});
			jqxhr.done(function(data){
				if(usersDataRef.observer != null){
					usersDataRef.observer.update(usersDataRef.admin, usersDataRef.pageNumber, data);
				}
			});
			jqxhr.fail(function(){
				console.log('fail');
			});
		},

		deleteUser : function(id){

		}
};

function UsersObserver(usersData){
	usersData.observer = this;
	this.usersDiv = $("#usersDiv");
	this.pagesDiv = $("#pageDiv");
}

UsersObserver.prototype = {
		update : function(admin, pageNumber, usersDataHTML){
			console.log("update -> page : " + pageNumber + ", admin : " + admin);
			this.usersDiv.html(usersDataHTML);
		},

		loading : function(){
			if(language == 'french'){
				console.log('chargement des données en cours ...')
			}
			else{

			}
		}
};

var usersData = new UsersData();
var usersObserver = new UsersObserver(usersData);