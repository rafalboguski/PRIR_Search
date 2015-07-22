'use strict';

angular.module('myApp.results', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/results/:word', {
            templateUrl: 'results/results.html',
            controller: 'ResultsCtrl'
        });
    }])


    .controller('ResultsCtrl', function ($scope, $http, $routeParams, apiService, myService) {
        $scope.init = function () {
            //$scope.data_ready = false;
            //$scope.hour = 13;
            $scope.word = $routeParams.word;

            myService.async().then(function(d) {
                $scope.searchTime = d.data.searchTime;
                $scope.files = d.data.data.reverse();

            });


            //apiService.Search($routeParams.word).then(function (res) {
            //    $scope.searchTime = res.data.searchTime;
            //    $scope.files = res.data.data.reverse();
            //    $scope.data_ready = true;
            //});
        }
    }


);

//
//angular.module('APP', ['chieffancypants.loadingBar', 'ngAnimate']).
//    controller("ExampleController",['$scope','$http',function($scope,$http){
//        $scope.getUsers = function(){
//            $scope.data=[];
//            var url = "http://www.filltext.com/?rows=10&fname={firstName}&lname={lastName}&delay=3&callback=JSON_CALLBACK"
//            $http.jsonp(url).success(function(data){
//                $scope.data=data;
//            })
//        }
//        $scope.getUsers()
//
//    }])