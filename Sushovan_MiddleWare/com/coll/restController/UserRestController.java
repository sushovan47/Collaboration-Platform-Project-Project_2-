package com.coll.restController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.UserDAO;
import com.coll.model.UserDetail;

@RestController
public class UserRestController 
{
	@Autowired
	UserDAO userDAO;
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserDetail user)
	{
		user.setIsOnline("Y");
		user.setRole("ROLE_USER");
		user.setStatus("A");
		if(userDAO.registerUser(user))
		{
			return new ResponseEntity<String>("New User Register",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in  Restering user",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getUser/{username}")
	public ResponseEntity<UserDetail> getUser(@PathVariable("username") String username)
	{
		UserDetail user=userDAO.getUser(username);
		
		if(user!=null)
		{
			return new ResponseEntity<UserDetail> (user,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<UserDetail>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/updateUser/{username}")
	public ResponseEntity<String> updateUser(@PathVariable("username")String username,@RequestBody UserDetail user)
	{
		UserDetail user1=userDAO.getUser(username);
		
		user1.setMemberName(user.getMemberName());
		user1.setEmailId(user.getEmailId());
		if(userDAO.updateUser(user1))
		{
			return new ResponseEntity<String>("User Detail is updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in UserDetail Updating ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/checkUser")
	public ResponseEntity<UserDetail> checkUser(@RequestBody UserDetail user,HttpSession session)
	{
		UserDetail user1=userDAO.checkUser(user);
		
		if(user1!=null)
		{
			session.setAttribute("userDetail", "user1");
			return new ResponseEntity<UserDetail>(user1,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(user1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
