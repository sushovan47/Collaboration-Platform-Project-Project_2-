package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coll.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addFriend(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteFriend(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Friend getFriend(String friendId) 
	{
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class,friendId);
		session.close();
		return friend;
	}

	@Override
	public List<Friend> listFriend()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend");
		List<Friend> listFriend =query.list();
		return listFriend;
	}

}
