package com.coll.DAOTest;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
import com.coll.model.Blog;
import com.coll.model.Job;

public class JobDAOImplTest 
{

	public static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		context.refresh();
		
		jobDAO=(JobDAO) context.getBean("jobDAO");
		
		
	}
	
	@Test
	@Ignore
	public void addJobTest()
	{
		Job job =new Job();
		job.setJobId(1001);
		job.setDesignation("Senior Architect");
		job.setCompanyName("NewHorizon Ionfotech Solution");
		job.setJobDesc("end end java Stack Knowledge with must 5 year experience");
		job.setCTC(800000);
		job.setJobLocation("Karnataka,Bangalore");
		job.setSkill("Java,Python,C#");
		job.setLastDatetoApply(new java.util.Date(2019, 05, 30));
		
		assertTrue("Problem in adding a job",jobDAO.addJob(job));
	}
	@Test
	
	public void updateJobTest()
	{
		Job job=jobDAO.getJob(993);
		
		job.setLastDatetoApply(new Date());
		job.setCTC(345000);
		assertTrue("Problem in updating Job",jobDAO.updateJob(job));
		
		System.out.println("JobDate apply has been udated in the Database");
	}
	@Test
	@Ignore
	public void showJobTest()
	{
	
		List<Job> jobList=jobDAO.showJobs();
		assertTrue("Problem in Listing the Job",jobList.size()>0);
		
		for(Job job:jobList)
		{
			System.out.println(job.getDesignation()+"::");
			System.out.println(job.getJobDesc()+"::");
			System.out.println(job.getCompanyName()+"::");
			System.out.println(job.getLastDatetoApply()+"");		
		}
	}
	@Test
	@Ignore
	public void getJobTest()
	{
		Job job=jobDAO.getJob(1012);
		assertNotNull("Problem in reteriving a particular job",job);
		
		
		System.out.println(job.getJobId());
		System.out.println(job.getDesignation()+"::");
		System.out.println(job.getJobDesc()+"::");
		System.out.println(job.getCompanyName()+"::");
		System.out.println(job.getLastDatetoApply()+"");
	}

}
