'use strict';


angular.module('familytree.config', []);

app.config(function($routeProvider, $httpProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/home.html'
	}).when('/addPerson', {
		templateUrl : 'views/person/person.html',
		controller : 'PersonController'
	}).otherwise({
		redirectTo : '/'
	});

	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
} );

app.run([ "$rootScope", "$location", function($rootScope, $location) {
} ]);
