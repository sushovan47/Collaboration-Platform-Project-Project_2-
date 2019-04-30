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

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

@RestController
public class BlogRestController 
{
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping("/showAllBlogs")
	public ResponseEntity<List<Blog>> showAllBlogs()
	{
		List<Blog> blogList=blogDAO.listBlog();
		
		System.out.println("Blog List Size:"+blogList.size());
		
		if(blogList.size()>0)
		{
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new Date());
		blog.setLikes(1);
		blog.setDislikes(0);
		blog.setStatus("A");
		blog.setUsername("sudhir");
		
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String> ("Blog added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem Occured during adding ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Problem Occured during deleting",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.incLikes(blog))
		{
			return new ResponseEntity<String>("Blog IncrementLikes added",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Problem Occured during increment likes",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/incrementDislikes/{blogId}")
	public ResponseEntity<String> incrementDislikes(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.incDisLikes(blog))
		{
			return new ResponseEntity<String>("Blog IncrementDislikes added",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Problem Occured during IncrementDislikes",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.approveBlog(blog))
		{
			return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Problem in approving Blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.rejectBlog(blog))
		{
			return new ResponseEntity<String>("Blog Rejected",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Problem in Rejecting Blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blog!=null)
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/updateBlog/{blogId}")
	public ResponseEntity<String> updateBlog(@PathVariable("blogId") int blogId, @RequestBody Blog blog)
	{
		Blog blog1=blogDAO.getBlog(blogId);
		blog1.setBlogName(blog.getBlogName());
		blog1.setBlogContent(blog.getBlogContent());
		if(blogDAO.updateBlog(blog1))
		{
			return new ResponseEntity<String>("Blog Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem Occured While Updating Blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
