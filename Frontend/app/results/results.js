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



  });

