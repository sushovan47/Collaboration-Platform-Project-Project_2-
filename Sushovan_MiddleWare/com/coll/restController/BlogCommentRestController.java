package com.coll.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

@RestController
public class BlogCommentRestController 
{
	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	@GetMapping(value="/listBlogComment/{blogId}")
	public ResponseEntity<List<BlogComment>> listBlogComment(@PathVariable("blogId") int blogId)
	{
		List<BlogComment> listBlogCmmnt=blogCommentDAO.listBlogComment(blogId);
		if(listBlogCmmnt.size()>0)
		{
			return new ResponseEntity<List<BlogComment>>(listBlogCmmnt,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(listBlogCmmnt,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment)
	{
		blogComment.setCreateDate(new Date());
		if(blogCommentDAO.addBlogComment(blogComment))
		{
			return new ResponseEntity<String>("BlogComment Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in adding BlogComment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/getBlogComment/{commentId}")
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("commentId") int commentId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
		
		if(blogComment!=null)
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/deleteBlogComment/{commentId}")
	public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId") int commentId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
		
		if(blogCommentDAO.deleteBlogComment(blogComment))
		{
			return new ResponseEntity<String>("Comment Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem occured during Comment deleting",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
