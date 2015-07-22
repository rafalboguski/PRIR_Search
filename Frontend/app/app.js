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


    .factory('myService', function($http) {
        var myService = {
            async: function() {
                // $http returns a promise, which has a then function, which also returns a promise
                var promise = $http.get('http://localhost:4567' + '/search/' + 'a').then(function (response) {
                    // The then function here is an opportunity to modify the response
                    console.log(response);
                    // The return value gets picked up by the then in the controller.
                    return response;
                });
                // Return the promise to the controller
                return promise;
            }
        };
        return myService;
    })

    .service('apiService', function ($http) {

        var apiUrl = 'http://localhost:4567';

        this.Search = function (word) {
            return $http.get(apiUrl + '/search/' + word);
        };
        this.getFiles = function () {
            return $http.get(apiUrl + '/files');
        };

        this.addFile = function (title, content, folder) {
            return $http({
                method: 'POST',
                url: apiUrl + '/push/',
                data: {
                    'filename': title,
                    'data': content,
                    'folder': folder
                },
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });
        };


    })

.filter('makeRange', function() {
    return function(input) {
        var lowBound, highBound;
        switch (input.length) {
            case 1:
                lowBound = 0;
                highBound = parseInt(input[0]) - 1;
                break;
            case 2:
                lowBound = parseInt(input[0]);
                highBound = parseInt(input[1]);
                break;
            default:
                return input;
        }
        var result = [];
        for (var i = lowBound; i <= highBound; i++)
            result.push(i);
        return result;
    };
});
