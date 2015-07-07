'use strict';


angular.module('myApp', [
  'ngRoute',
  'myApp.results',
  'myApp.books'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/books'});
}]);
