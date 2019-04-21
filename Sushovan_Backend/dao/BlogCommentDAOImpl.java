package com.coll.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogComment)
	{
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public BlogComment getBlogComment(int commentId) 
	{
		Session session=sessionFactory.openSession();
		BlogComment blogComment=session.get(BlogComment.class,commentId);
		session.close();
		
		return blogComment;
	}

	@Override
	public List<BlogComment> listBlogComment(int blogId) 
	{
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", blogId);
		List<BlogComment> commentlist=query.list();
		session.close();
		
		return commentlist;
	}

}
