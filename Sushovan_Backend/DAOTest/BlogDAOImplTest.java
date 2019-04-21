package com.coll.DAOTest;
import static org.junit.Assert.*;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

public class BlogDAOImplTest
{
	public static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
		
		blogDAO=(BlogDAO) context.getBean("blogDAO");
	}
	@Test
	
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogId(2001);
		blog.setBlogName("C#");
		blog.setCreateDate(new Date());
		blog.setBlogContent("All C# Programming Language Concept is new clearly discussed in this content");
		blog.setUsername("admin123");
		blog.setStatus("NA");
		blog.setLikes(1);
		blog.setDislikes(0);
		assertTrue("Problem in adding Blog",blogDAO.addBlog(blog));
		
		System.out.println("Data Stored into the Oracle Database Please Check you XE database");
	}
	@Test
	@Ignore
	public void deleteBlogTest()
	{
		Blog blog=blogDAO.getBlog(1001);
		assertTrue("Problem in deleting Blog",blogDAO.deleteBlog(blog));
		
		System.out.println("Given bolgId has been deleted from database");
	}
	@Test
	@Ignore
	public void updateBlogTest()
	{
		Blog blog=blogDAO.getBlog(52);
		blog.setBlogName("Object_Oriented_Prgramming in Java");
		assertTrue("Problem in updating Blog",blogDAO.updateBlog(blog));
		
		System.out.println("BlogName has been udated in the Database");
	}
	@Test
	@Ignore
	public void approvedBlogTest()
	{
		Blog blog=blogDAO.getBlog(52);
		assertTrue("Problem in approving Blog",blogDAO.approveBlog(blog));
		
		System.out.println("Blog Status has been updated from BlogDAOImpl class given method");
	}
	@Test
	@Ignore
	public void rejectBlogTest()
	{
		Blog blog=blogDAO.getBlog(152);
		assertTrue("Problem in Rejecting Blog",blogDAO.rejectBlog(blog));
		System.out.println("Blog Status has been updated from BlogDAOImpl class given method");
	}
	
	@Test
	@Ignore
	public void increamentLikesTest()
	{
		Blog blog=blogDAO.getBlog(52);
		assertTrue("Problem in incrementing Likes in Blog ",blogDAO.incLikes(blog));
		
		System.out.println("Incremented the likes in given blogId Table row");
	}
	@Test
	@Ignore
	public void iecrementDisLikesTest()
	{
		Blog blog=blogDAO.getBlog(52);
		assertTrue("Problem in incrementing DisLikes in Blog ",blogDAO.incDisLikes(blog));
		
		System.out.println("Incremented the Dislikes in given blogId Table row");
	}
}
