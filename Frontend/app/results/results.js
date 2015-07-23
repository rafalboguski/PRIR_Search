'use strict';

var app = angular.module('myApp.results', ['ngRoute',
    'angularUtils.directives.dirPagination'
])

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
                $scope.searchTime = res.data.searchTime;
                console.log('Promise is now resolved: ', $scope.searchTime);
                $scope.files = res.data.data.reverse();
                $scope.data_ready = true;
            });
        };

        $scope.loadResultContent = function (idx) {
            if (!$scope.files[idx].open) {
                $scope.files[idx].limit = 12;
                $scope.files[idx].rrr = $scope.files[idx].positions;
                $scope.files[idx].open = true;
            }
        };

        $scope.loadMoreResult = function (idx) {
            $scope.files[idx].limit += 12;
        }
    }
);

