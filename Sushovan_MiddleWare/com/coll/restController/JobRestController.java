package com.coll.restController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.JobDAO;
import com.coll.model.Job;

@RestController
public class JobRestController 
{
	@Autowired
	JobDAO jobDAO;
	
	@GetMapping(value="/showAllJobs")
	public ResponseEntity<List<Job>> showJobs()
	{
		List<Job> jobList=jobDAO.showJobs();
		
		System.out.println("Job List Size:"+jobList.size());
		
		if(jobList.size()>0)
		{
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<String>("Job Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("problem in adding Job",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping(value="/updateJob/{jobId}")
	public ResponseEntity<String> updateJob(@PathVariable("jobId") int jobId ,@RequestBody Job job)
	{
		Job job1=jobDAO.getJob(jobId);
		job1.setJobDesc(job.getJobDesc());
		job1.setCompanyName(job.getCompanyName());
		if(jobDAO.updateJob(job1))
		{
			return new ResponseEntity<String> ("Job updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on updating",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/getJob/{jobId}")
	public ResponseEntity<Job> getJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		if(job!=null)
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Job>(job,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
