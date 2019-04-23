package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coll.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAImpl implements ForumCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addComment(ForumComment comment)
	{
		try
		{
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteComment(ForumComment comment) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateComment(ForumComment comment) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(comment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<ForumComment> listcomment()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment");
		List<ForumComment> listForumComment=query.list();
		session.close();
		return listForumComment;
	}

	@Override
	public ForumComment getComment(int commentId)
	{
		Session session=sessionFactory.openSession();
		ForumComment comment=session.get(ForumComment.class,commentId);
		session.close();
		return comment;
	}
	
}
