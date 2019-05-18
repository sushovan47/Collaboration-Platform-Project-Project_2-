package com.coll.DAOTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.coll.dao.FriendDAO;
import com.coll.model.Friend;

public class FriendDAOImplTest 
{

public static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
		
		friendDAO=(FriendDAO) context.getBean("friendDAO");
	}
	@Test
	@Ignore
	public void sendFriendRequest()
	{
		Friend friend=new Friend();
		friend.setUsername("Ayan");		//Whichever you have in database.
		friend.setFriendUserName("ramesh");
		assertTrue("Problem in sending Request",friendDAO.sendFriendRequest(friend));
		
		System.out.println("Friend request sent to another User");
	}
	@Test
	@Ignore
	public void acceptFriendRequest()
	{
		assertTrue("Problem on accepting Request",friendDAO.acceptFriendRequest(964));
		
		System.out.println("Friend request accept from another User");
	}
	@Test
	@Ignore
	public void deleteFriendRequest()
	{
		assertTrue("Problem on Deleting Request",friendDAO.deleteFriendRequest(964));
		
		System.out.println("Friend request delete from another User");
	}
	@Test
	@Ignore
	public void showFriendListTest()
	{
		List<Friend> friendList=friendDAO.showFriendList("Ayan");
		assertTrue("Problem in showing Friend List",friendList.size()>0);
		
		System.out.println("=====Friend List of accepted Friends Only=====");
		
		for(Friend friend:friendList)
		{
			System.out.println(friend.getUsername()+"::::");
			System.out.println(friend.getFriendUserName());
		}
	}
	@Test
	public void pendingFriendListTest()
	{
		List<Friend> friendList=friendDAO.showPendingFriendRequest("Radhika");
		assertTrue("Problem in showing Friend List",friendList.size()>0);
		
		System.out.println("=====Friend List of Pending Friends Only=====");
		
		for(Friend friend:friendList)
		{
			System.out.print(friend.getUsername()+"::::");
			System.out.print(friend.getFriendUserName());
		}
	}

}
