myApp.controller("BlogController",function($scope,$location,$http,$rootScope)
		{
		
			$scope.blog={"blogId":0,"blogName":"","blogContent":"","username":"","createDate":"","status":"","likes":"","dislikes":""};
			
			$scope.blogData;   //For adding all kind of Blog related Data .
			
			$scope.addBlog=function()
			{
				console.log('I am in add blog Function');
				
				$https.post('http://localhost:8081/Sushovan_Middleware/addBlog',$scope.blog)
				.then(function(response)
						{
							alert("Added a Blog Information");
							$location.path("/addBlog");
						});
			}
			
			$scope.incrementLikes=function(blogId)
			{
				console.log('I am in Increment Like Function')
				$http.get('http://localhost:8081/Sushovan_Middleware/incrementLikes'+blogId)
				.then(function(response)
				{
					alert("Blog likes are incremented");
				});
			}
			$scope.incrementDislikes=function(blogId)
			{
				console.log('I am in Increment Dislike Function')
				$http.get('http://localhost:8081/Sushovan_Middleware/incrementDislikes'+blogId)
				.then(function(response)
				{
					alert("Blog Dislikes are incremented");
				});
			}
			
			$scope.deleteBlogs=function(blogId)
			{
				console.log('I am in Delete Blog Id Fincyion')
				$http.get('http://localhost:8081/Sushovan_Middleware/deleteBlog'+blogId)
				.then(function(response)
				{
					alert("Blog is Deleted with blogId"+blogId);
					
				});
			}
			$scope.approve=function(blogId)
			{
				console.log('I am in Blog Id Fincyion')
				$http.get('http://localhost:8081/Sushovan_Middleware/approveBlog'+blogId)
				.then(function(response)
				{
					alert("Blog is accepted with blogId"+blogId);
					
				});
			}
			$scope.reject=function(blogId)
			{
				console.log('I am in Blog Id Function')
				$http.get('http://localhost:8081/Sushovan_Middleware/rejectBlog'+blogId)
				.then(function(response)
				{
					alert("Blog is Rejected with blogId"+blogId);
					
				});
			}
			$scope.showComment=function(blogId)
			{
				console.log('I am in Show Comment Function')
				$rootScope.blogId=blogId;
				$location.path("/showBlogComments");
			
			}
			function loadBlogs()
			{
				console.log('Blog List');
				$http.get('http://localhost:8081/Sushovan_Middleware/showAllBlogs')
				.then(function(response)
				{
					console.log(response.data);
					$scope.blogData=response.data;
				});
			}
			loadBlogs();
	
		});