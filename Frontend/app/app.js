'use strict';


angular.module('myApp', [
  'ngRoute',
  'myApp.results',
  'myApp.books',
  'myApp.utils',
  'ngAnimate',
  'ui.bootstrap'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/books'});
}])




.service('GlobalService', function($http) {
    var apiUrl = 'http://localhost:4567';


    this.Search = function(word) {
        return $http.get(apiUrl + '/search/' + word);
    };

})

.run(function($rootScope, GlobalService) {
        return $rootScope.GlobalService = GlobalService;
    }
);