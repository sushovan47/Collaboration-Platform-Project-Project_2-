myApp.controller("BlogController",function($scope,$location,$http,$rootScope)
{
	function loadBlogComments()
	{
		console.log('Blog Comment List');
		$http.get('http://localhost:8081/Sushovan_Middleware/listBlogComment/'+$rootScope.blogId)
		.then(function(response)
		{
			console.log(response.data);
			$scope.blogCommentData=response.data;
		});
	}
	
	function loadBlogData()
	{
		console.log('I am in Load BlogData Function')
		$http.get('http://localhost:8081/Sushovan_Middleware/getBlog'+$rootScope.blogId)
		.then(function(response)
		{
			$scope.blog=response.data;
		});
	}
	loadBlogData();
	loadBlogComments();
			
});