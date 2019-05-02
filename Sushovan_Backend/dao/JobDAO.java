package com.coll.dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);
	public List<Job> showJobs(Job job); //Apply for job you can implement that is not mandatory.
	public Job getJob(int jobId);

}
