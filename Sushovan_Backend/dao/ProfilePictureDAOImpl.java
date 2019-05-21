package com.coll.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(ProfilePicture profilePicture)
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
	}

	@Override
	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=session.get(ProfilePicture.class,username);
		session.close();
		return profilePicture;
	}
	//Side by side You have to create a table in Oracle Database named as "ProfilePicture" with username and  image blob two parameters. 
}
