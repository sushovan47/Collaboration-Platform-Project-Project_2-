package com.coll.dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> showJobs();     //Apply for job you can implement that is not mandatory.
	public Job getJob(int jobId);

}
