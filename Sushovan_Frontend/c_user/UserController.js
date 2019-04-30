myApp.controller("UserController",function($scope)
{
	$scope.user={'username':'','password':'','memberName':'','EmailId':'','role':'','status':'','isOnline':''};
	
	$scope.loginCheck=function()
	{
		console.log("I am in Login Check");
		console.log($scope.user.username);
		console.log($scope.user.password);	
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
	}
	
	
});