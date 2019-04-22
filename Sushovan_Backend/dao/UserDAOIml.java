package com.coll.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;


import com.coll.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOIml implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;		
		}
		catch(Exception e)
		{
			return false;
		}	
	}

	@Override
	public boolean updateUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public UserDetail checkUser(UserDetail user) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail where username=:uname and password=:passwd");
		query.setParameter("uname",user.getUsername());
		query.setParameter("passwd",user.getPassword());
		List<UserDetail> listuser=query.list();
		session.close();
		if(listuser.size()>0)
		{
			return listuser.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public UserDetail getUser(String username) 
	{
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class, username);
		session.close();
		return user;
	}

}
