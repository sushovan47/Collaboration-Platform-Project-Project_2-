package com.coll.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Friend> showFriendList(String loginName) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where(username=:login or friendusername=:login1 )and status='A'");
		query.setParameter("login", loginName);
		query.setParameter("login1", loginName);
		
		List<Friend> friendList=query.list();
		
		return friendList;
	}

	@Override
	public List<Friend> showPendingFriendRequest(String loginName) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendusername=:login1 and status='P'");
		query.setParameter("login1", loginName);
		
		List<Friend> friendList=query.list();
		
		return friendList;
	}

	@Override
	public List<UserDetail> showSuggestedFriendRequest(String loginName)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select username from userdetail where username not in(select friendusername from Friend where username='"+loginName+"' and (status='A' or status='P'))and username not in(select username from Friend where friendusername='"+loginName+"'and(status='A' or status='P'))and username!='"+loginName+"");
		List<String> friendList=query.list();
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int i=0;
		while(i<friendList.size())
		{
			UserDetail user=session.get(UserDetail.class, friendList.get(i).toString().trim());
			listUserDetail.add(user);
			i++;
		}
		
		return listUserDetail;
	}

	@Override
	public boolean sendFriendRequest(Friend friend) 
	{
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean acceptFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class, friendId);
			session.close();
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	
}
