'use strict';

angular.module('myApp.results', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/results/:word', {
            templateUrl: 'results/results.html',
            controller: 'ResultsCtrl'
        });
    }])


    .controller('ResultsCtrl', function ($scope, $http, $routeParams, apiService) {
        $scope.init = function () {

            $scope.word = $routeParams.word;

            apiService.Search($routeParams.word).then(function (res) {
                $scope.files = res.data.reverse();
            });
        }
    });

