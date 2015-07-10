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
}]);
