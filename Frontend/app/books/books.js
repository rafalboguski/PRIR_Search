'use strict';

angular.module('myApp.books', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/books', {
    templateUrl: 'books/books.html',
    controller: 'BooksCtrl'
  });
}])

.controller('BooksCtrl',function($scope,$http){
        $scope.init = function(){
            $http.get("http://localhost:4567/files").success(function(data){
                $scope.books = data.reverse();
            }).error(function(){
                alert("Enable cross site refernece ");
            });
        }






  });

