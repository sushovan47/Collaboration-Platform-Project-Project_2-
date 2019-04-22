package com.coll.DAOTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogCommentDAO;
import com.coll.dao.UserDAO;
import com.coll.model.UserDetail;

public class UserDAOImplTest {

public static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
		
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	@Test
	@Ignore
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("tarun");
		user.setPassword("12345");
		user.setMemberName("Tarun Kumar");
		user.setEmailId("ramesh@gmail.com");
		user.setRole("ROLE_ADMIN");
		user.setStatus("A");
		user.setIsOnline("Y");
		
		assertTrue("Problem in registering",userDAO.registerUser(user));
		
		System.out.println("UserDetail is being Registered with Database Table");
		
	}
	@Test
	public void updateUserTest()
	{
		UserDetail user=userDAO.getUser("vinod");
		
		user.setEmailId("vinod@gmail.com");
		assertTrue("Problem in Updating User",userDAO.updateUser(user));
		
		System.out.println("User Detail is being Updated in database table");
		
	}
	@Test
	@Ignore
	public void checkUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("vinod");
		user.setPassword("12345");
		
		UserDetail user1=userDAO.checkUser(user);
		assertNotNull("Problem in Checking User",user1);    //Checking not true or false ,checking whether the user is avialable or not so use assertNotNull
		
		System.out.println("Get the information from UserDetail table from database");
		System.out.println(user1.getEmailId());
	}

}
