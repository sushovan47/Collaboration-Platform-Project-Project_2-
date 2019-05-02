package com.coll.DAOTest;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
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
	@SuppressWarnings("deprecation")
	@Test
	public void addJobTest()
	{
		Job job =new Job();
		job.setJobId(1001);
		job.setDesignation("Programmer");
		job.setCompanyName("BlueSoft Infotech");
		job.setJobDesc("End to end Java Stack Knowledge");
		job.setCTC(500000);
		job.setJobLocation("Pune");
		job.setSkill("Spring ,Hibernate");
		job.setLastDatetoApply(new java.util.Date(2019, 05, 02));
		
		assertTrue("Problem in adding a job",jobDAO.addJob(job));
	}

}
