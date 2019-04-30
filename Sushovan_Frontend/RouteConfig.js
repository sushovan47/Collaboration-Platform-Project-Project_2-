var myApp=angular.module("myApp",['ngRoute']);
myApp.config(function($routeProvider)
{	
	alert("I am in RouteConfig Function");
	
$routeProvider.when("/",{templateUrl:"index.html"})

.when("/login",{templateUrl:"c_user/Login.html"})

.when("/register",{templateUrl:"c_user/Register.html"});

});