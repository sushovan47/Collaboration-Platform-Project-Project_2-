package com.coll.DAOTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.coll.dao.FriendDAO;
import com.coll.model.Forum;
import com.coll.model.Friend;

public class FriendDAOImplTest 
{

public static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
		
		friendDAO=(FriendDAO) context.getBean("friendDAO");
	}
	@Test
	@Ignore
	public void addFriendTest()
	{
		Friend friend=new Friend();
		friend.setFreindId("ravi67");
		friend.setFriendName("Ravi Shankar Kumar");
		friend.setUsername("tarun");
		friend.setStatus("Y");
		
		assertTrue("Problem in adding Friend",friendDAO.addFriend(friend));
		
		System.out.println("Data Stored Into The Friend Table in Oracle Database");
	}
	@Test
	@Ignore
	public void deleteFriendTest()
	{
		Friend friend=friendDAO.getFriend("kou76");
		assertTrue("Problem occured during deleting Forum",friendDAO.deleteFriend(friend));
		
		System.out.println("Data is deleted From Database Successfully..");
	}
	@Test
	public void listFriendTest()
	{
		List<Friend> listFriend=friendDAO.listFriend();
		assertTrue("Problem in listing Friend details",listFriend.size()>0);
		
		System.out.println("Data Retrived from Database");
		for(Friend friend:listFriend)
		{
			System.out.print(friend.getFreindId()+":::");
			System.out.print(friend.getFriendName()+":::");
			System.out.print(friend.getUsername()+":::");
			System.out.println(friend.getStatus());
		}
		
	}
	

}
