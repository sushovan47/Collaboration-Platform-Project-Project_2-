package com.coll.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

@RestController
public class ForumRestController 
{
	@Autowired
	
	ForumDAO forumDAO;
	
	@GetMapping("/showAllForum")
	public ResponseEntity<List<Forum>> showAllForum()
	{
		List<Forum> listForum=forumDAO.listForum();
		
		System.out.println("Froum Size="+listForum.size());
		
		if(listForum.size()>0)
		{
			return new ResponseEntity<List<Forum>>(listForum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForum,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new Date());
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on adding Forum ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateForum/{ForumId}")
	public ResponseEntity<String> updateForum(@PathVariable("ForumId") int ForumId ,@RequestBody Forum forum)
	{
		Forum forum1=forumDAO.getForum(ForumId);
		
		forum1.setUsername(forum.getUsername());
		forum1.setForumName("Core Java");
		
		if(forumDAO.updateForum(forum1))
		{
			return new ResponseEntity<String>("Forum Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on Updating Forum ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/deleteForum/{ForumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("ForumId") int ForumId)
	{
		Forum forum=forumDAO.getForum(ForumId);
		if(forumDAO.deleteForum(forum))
		{
			return new ResponseEntity<String>("Forum Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on deleting Forum ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getForum/{ForumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("ForumId") int ForumId)
	{
		Forum forum=forumDAO.getForum(ForumId);
		if(forum!=null)
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
