angular.module('person').controller('PersonController', function($scope, $rootScope, personService) {
	
});

angular.module('person').service('personService', function($rootScope) {
    var edit;
    var updateUser;

    return {
        getEdit: function() {
            return edit;
        },
        setEdit: function(value) {
            edit = value;
        },

        getUpdateUser: function() {
            return updateUser;
        },
        setUpdateUser: function(value) {
            updateUser = value;
        }
    }

});