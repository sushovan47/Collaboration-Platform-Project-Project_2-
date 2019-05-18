package com.coll.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl  implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@Override
	public boolean updateJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public List<Job> showJobs() 
	{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Job.class);
		criteria.add(Restrictions.ge("lastDatetoApply",new Date()));
		List<Job> joblist=criteria.list();
		session.close();
		return joblist;
	}

	@Override
	public Job getJob(int jobId)
	{
		Session session=sessionFactory.openSession();
		Job job=session.get(Job.class,jobId);
		session.close();
		return job;
	}

	
	
}
