// angular.module('stats',['ngRoute','ui.select2','ngSanitize']).controller("StatsCtrl", function($scope){
//     $scope.select2Options = {
//         allowClear:true
//     };
// });
$(document).ready(function () {
    $(".select-team,.select-league").select2();
});
