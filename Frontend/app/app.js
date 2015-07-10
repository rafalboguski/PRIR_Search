'use strict';


angular.module('myApp', [
    'ngRoute',
    'myApp.results',
    'myApp.books',
    'myApp.utils',
    'ngAnimate',
    'ui.bootstrap'
]).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/books'});
    }])


    .service('apiService', function ($http) {

        var apiUrl = 'http://localhost:4567';

        this.Search = function (word) {
            return $http.get(apiUrl + '/search/' + word);
        };
        this.getFiles = function () {
            return $http.get(apiUrl + '/files' );
        };
    });

