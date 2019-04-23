package com.coll.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addForum(Forum forum)
	{
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Override
	public boolean updateForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Forum getForum(int ForumId) 
	{
		
		Session session=sessionFactory.openSession();
		Forum forum =session.get(Forum.class,ForumId);
		session.close();
		
		return forum;
	}

	

	@Override
	public List<Forum> listForum() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> forumlist=query.list();
		session.close();
		return forumlist;
	}
	

}
