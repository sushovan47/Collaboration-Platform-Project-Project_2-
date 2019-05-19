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

import com.coll.dao.ForumCommentDAO;
import com.coll.model.ForumComment;

@RestController
public class ForumCommentRestController 
{
	@Autowired
	
	ForumCommentDAO forumCommentDAO;
	
	@GetMapping("/showAllForumComment")
	public ResponseEntity<List<ForumComment>> showAllForumComment()
	{
		List<ForumComment> listForumComment=forumCommentDAO.listcomment();
		
		System.out.println("Froum Size="+listForumComment.size());
		
		if(listForumComment.size()>0)
		{
			return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addForumComment")
	public ResponseEntity<String> addForumComment(@RequestBody ForumComment forumComment)
	{
		forumComment.setCommentDate(new Date());
		if(forumCommentDAO.addComment(forumComment))
		{
			return new ResponseEntity<String>("ForumComment Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on adding ForumComment ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateForumComment/{commentId}")
	public ResponseEntity<String> updateForumComment(@PathVariable("commentId") int commentId ,@RequestBody ForumComment forumComment)
	{
		ForumComment comment=forumCommentDAO.getComment(commentId);
		
		comment.setUsername(forumComment.getUsername());
		
		if(forumCommentDAO.updateComment(comment))
		{
			return new ResponseEntity<String>("ForumComment Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on Updating ForumComment ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteForumComment/{commentId}")
	public ResponseEntity<String> deleteForumComment(@PathVariable("commentId") int commentId)
	{
		ForumComment comment=forumCommentDAO.getComment(commentId);
		
		
		if(forumCommentDAO.deleteComment(comment))
		{
			return new ResponseEntity<String>("ForumComment Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem on Deleting ForumComment ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getForumComment/{commentId}")
	public ResponseEntity<ForumComment> getForumComment(@PathVariable("commentId") int commentId)
	{
		ForumComment comment=forumCommentDAO.getComment(commentId);
		
		
		if(comment!=null)
		{
			return new ResponseEntity<ForumComment>(comment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<ForumComment>(comment,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
