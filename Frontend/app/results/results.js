'use strict';

angular.module('myApp.results', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/results', {
            templateUrl: 'results/results.html',
            controller: 'ResultsCtrl'
        });
    }])

    .controller('ResultsCtrl', function ($scope, $http) {
        $scope.init = function () {
            $http.get("http://localhost:4567/search/a").success(function (data) {
                $scope.files = data.reverse();
            }).error(function () {
                alert("Enable cross site refernece ");
            });
        }

        $scope.oneAtATime = true;

        $scope.groups = [
            {
                title: 'Dynamic Group Header - 1',
                content: 'Dynamic Group Body - 1'
            },
            {
                title: 'Dynamic Group Header - 2',
                content: 'Dynamic Group Body - 2'
            }
        ];

        $scope.items = ['Item 1', 'Item 2', 'Item 3'];

        $scope.addItem = function() {
            var newItemNo = $scope.items.length + 1;
            $scope.items.push('Item ' + newItemNo);
        };

        $scope.status = {
            isFirstOpen: true,
            isFirstDisabled: false
        };

    });

