myApp.controller("UserController",function($scope,$location,$http,$rootScope)
{
	$scope.user={"username":"","password":"","memberName":"","EmailId":"","role":"","status":"","isOnline":""};
	
	$scope.loginCheck=function()
	{
		console.log("I am in Login Check");
		console.log($scope.user.username);
		console.log($scope.user.password);	
		
		$http.post("http://localhost:8081/Sushovan_Middleware/checkUser",$scope.user)
		.then(function(response)
		{
			console.log('Logged In');
			$scope.user=response.data;
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser);
			$cookieStore.put('userdetails',response.data);
			console.log(response.data);
			$location.path("/userHome");
		});
	}
	$scope.logout=function()
	{
		console.log('I am in Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userdetails');
		$location.path("/login");
	}
	
	$scope.register=function()
	{
		console.log("I am in Register User Method");
		$scope.user.memberName="Tarun Kumar";
		$scope.user.EmailId="tarun@gmail.com";
		$scope.user.role="ROLE_USER";
		$scope.user.status='A';
		$scope.user.isOnline='Y';
		
		console.log($scope.user.memberName);
		console.log($scope.user.emailId);
		
		$http.post("http://localhost:8081/Sushovan_Middleware/registerUser",$scope.user)
		.then (function(response)
		{
			console.log('Registered');
			$location.path("/Login");
		});
	}
	
	
});
