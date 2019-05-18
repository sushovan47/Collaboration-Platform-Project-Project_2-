var myApp=angular.module("myApp",['ngRoute','ngCookies']);
myApp.config(function($routeProvider)
{	
	alert("I am in RouteConfig Function");
	
$routeProvider.when("/",{templateUrl:"index.html"})

.when("/login",{templateUrl:"c_user/Login.html"})
.when("/register",{templateUrl:"c_user/Register.html"})
.when("/addBlog",{templateUrl:"c_blog/AddBlog.html"})
.when("/manageBlog",{templateUrl:"c_blog/AdminBlog.html"})
.when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
.when("/showBlogComment",{templateUrl:"c_blog/showBlogComment.html"})
.when("/userHome",{templateUrl:"c_user/UserHome.html"});

});

myApp.run(function($rootScope,$cookieStore)
{
	
	console.log('I am in run function');
	console.log($rootScope.currentUser);
	
	if($rootScope.currentUser==undefined)
		{
			console.log($cookieStore.get('userdetails'));
			console.currentUser=$cookieStore.get('userdetails');
		}
});
