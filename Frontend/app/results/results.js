'use strict';

angular.module('myApp.results', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/results/:word', {
            templateUrl: 'results/results.html',
            controller: 'ResultsCtrl'
        });
    }])


    .controller('ResultsCtrl', function ($scope, $http, $routeParams, $rootScope) {
        $scope.init = function () {


            $scope.word = $routeParams.word;

            $rootScope.GlobalService.Search($routeParams.word).then(function (response) {
                $scope.files = response.data.reverse();
            });
        }
    });

