package com.coll.DAOTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

public class BlogCommentDAOImplTest 
{
public static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
		
		blogCommentDAO=(BlogCommentDAO) context.getBean("blogCommentDAO");
	}
	@Test
	@Ignore
	public void addBlogCommentTest()
	{
		BlogComment comment=new BlogComment();
		comment.setCommentId(1021);
		comment.setBlogId(1001);
		comment.setCommentData("Java");
		comment.setCreateDate(new Date());
		comment.setUsername("tarun");
		
		assertTrue("Problem in adding BlogComment",blogCommentDAO.addBlogComment(comment));
		
		System.out.println("Data Stored into the BlogComment Table please check your database");
	}
	@Test
	public void deleteBlogComment()
	{
		BlogComment comment= blogCommentDAO.getBlogComment(974);
		assertTrue("Problem on deleting BlogComment",blogCommentDAO.deleteBlogComment(comment));
		
		System.out.println("From BlogComment table given blogcommentId Data is deleted from Database");
		
	}
	@Test
	@Ignore
	public void listBlogCommentTest()		//Not Using Ignore Annotation for check both the blocks or methods in a single time .
	{
		List<BlogComment> commentList =blogCommentDAO.listBlogComment(1001);
		assertTrue("Problem in listing:",commentList.size()>0);
		
		System.out.println("Data Showing from Database");
		
		for(BlogComment comment:commentList)
		{
			System.out.print(comment.getCommentData()+"::::");
			System.out.print(comment.getBlogId()+"::::");
			System.out.print(comment.getCommentId()+"::::");
			System.out.println(comment.getUsername());
		}
	}
	
}
