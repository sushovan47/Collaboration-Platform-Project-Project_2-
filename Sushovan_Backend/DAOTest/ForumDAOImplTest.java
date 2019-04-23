package com.coll.DAOTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

public class ForumDAOImplTest 
{

public static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
		
		forumDAO=(ForumDAO) context.getBean("forumDAO");
	}
	@Test
	@Ignore
	public void addForumTest()
	{
		Forum forum =new Forum();
		forum.setForumId(84);
		forum.setForumName("Python");
		forum.setForumContent("Full pi Syllabi");
		forum.setUsername("tarun");
		forum.setCreateDate(new Date());
		forum.setStatus("Y");
		assertTrue("Problem in adding Forum",forumDAO.addForum(forum));
		
		System.out.println("Data stored into Database Check Forum table in Oracle Database");
	}
	@Test
	@Ignore
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(83);
		assertTrue("Problem occured during deleting Forum",forumDAO.deleteForum(forum));
		
		System.out.println("Data is deleted Fro Database Successfully..");
	}
	@Test
	@Ignore
	public void updateForumTest()
	{
		Forum forum =forumDAO.getForum(84);
		forum.setStatus("N");
		
		assertTrue("Problem in updating Forum",forumDAO.updateForum(forum));
		
		System.out.println("Database Table has been updated please check it");
	}
	@Test
	public void listForumTest()
	{
		List<Forum> listForum=forumDAO.listForum();
		assertTrue("Problem in listing Forum",listForum.size()>0);
		
		System.out.println("Data Retrived from Database");
		for(Forum forum:listForum)
		{
			System.out.print(forum.getForumId()+":::");
			System.out.print(forum.getForumContent()+":::");
			System.out.print(forum.getForunName()+":::");
			System.out.print(forum.getUsername()+":::");
			System.out.println(forum.getStatus());
		}
		
	}

}
