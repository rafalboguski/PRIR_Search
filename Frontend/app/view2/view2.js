'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl',function($scope,$http){
        $scope.init = function(){
            $http.get("http://localhost:4567/files").success(function(data){
                $scope.friends = data;
            }).error(function(){
                alert("B³¹d ");
            });
        }


});
