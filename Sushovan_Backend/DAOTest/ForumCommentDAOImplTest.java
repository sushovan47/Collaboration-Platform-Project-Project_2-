package com.coll.DAOTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.coll.dao.ForumCommentDAO;
import com.coll.model.ForumComment;
public class ForumCommentDAOImplTest 
{public static ForumCommentDAO forumCommentDAO;

@BeforeClass
public static void initialize()
{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	
	context.scan("com.coll");
	
	context.refresh();
	
	forumCommentDAO=(ForumCommentDAO) context.getBean("forumCommentDAO");		
}
@Test
@Ignore
public void addCommentTest()
{
	ForumComment comment=new ForumComment();
	comment.setCommentId(128);
	comment.setForumId(89);
	comment.setCommentName("you are great sir  !!");
	comment.setCommentDate(new Date());
	comment.setUserId(182018);
	comment.setUsername("Ayan Ganguli");
	
	assertTrue("Problem in adding Comment",forumCommentDAO.addComment(comment));
	
	System.out.println("Data Stored into the ForumComment Table in Oracle Database");
	
}
@Test
@Ignore
public void deleteCommentTest()
{
	ForumComment comment=forumCommentDAO.getComment(77);
	assertTrue("Problem in deleting Comment",forumCommentDAO.deleteComment(comment));
	
	System.out.println("Data deleted from ForumComment table");
}
@Test
@Ignore
public void updateCommentTest()
{
	ForumComment comment =forumCommentDAO.getComment(74);
	comment.setCommentName("your explain the most easiest way");
	
	assertTrue("Problem in updating Comment",forumCommentDAO.updateComment(comment));
	
	System.out.println("DataBase Updated Successfully");
}
@Test
public void listForumCommentTest()
{
	List<ForumComment> listComment=forumCommentDAO.listcomment();
	assertTrue("Problem in listing ForumDetails",listComment.size()>0);
	
	System.out.println("Data Retrived from DataBase");
	for(ForumComment comment:listComment)
	{
		System.out.print(comment.getCommentId()+":::");
		System.out.print(comment.getCommentName()+":::");
		System.out.print(comment.getForumId()+":::");
		System.out.print(comment.getUserId()+":::");
		System.out.print(comment.getUsername()+":::");
		System.out.println(comment.getCommentDate());
	}
}

}
