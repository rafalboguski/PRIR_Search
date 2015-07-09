'use strict';


angular.module('myApp', [
  'ngRoute',
  'myApp.results',
  'myApp.books',
  'ngAnimate'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/books'});
}]);
