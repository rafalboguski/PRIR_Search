'use strict';

angular.module('myApp.books', ['ngRoute', 'ngAnimate'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/books', {
            templateUrl: 'books/books.html',
            controller: 'BooksCtrl'
        });
    }])

    .controller('BooksCtrl', function ($scope, $http, $location, $timeout, apiService) {
        $scope.init = function () {

            apiService.getFiles().then(function (res) {
                $scope.books = res.data.reverse();
                // how to add new field
                $scope.books.forEach(function (b) {
                    b.tmp = 143;
                });
            });
        };

        $scope.search = function () {
            $('#searchModal').modal('hide');

            $timeout(function () {
                $location.path('results/' + $scope.word);
            }, 250); // delay 250 ms


        };

        $scope.addFile = function(){

            apiService.addFile($scope.addTitle, $scope.addContent,$scope.addFolder).then(function (res) {
                $scope.addTitle = "";
                $scope.addContent = "";
                $scope.addFolder = "";
                $('#addModal').modal('hide');
                $scope.init();
            });
        };
        $scope.expandLink = function(){
            contentAreas[$scope.openAll? 'hide': 'show']()
                .trigger($scope.openAll? 'hide': 'show');
        };
    });

