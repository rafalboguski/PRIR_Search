'use strict';

angular.module('myApp.results', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/results/:word', {
            templateUrl: 'results/results.html',
            controller: 'ResultsCtrl'
        });
    }])




.controller('ResultsCtrl', function ($scope, $http, $routeParams) {
        $scope.init = function () {
            $http.get("http://localhost:4567/search/"+$routeParams.word).success(function (data) {
                $scope.word = $routeParams.word;
                $scope.files = data.reverse();
            }).error(function () {
                alert("Enable cross site refernece ");
            });
        }
    });

