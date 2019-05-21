package com.coll.restController;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coll.dao.ProfilePictureDAO;
import com.coll.model.ProfilePicture;
import com.coll.model.UserDetail;

@RestController
public class ProfilePictureRestController 
{
	@Autowired
	
	ProfilePictureDAO profilePictureDAO;
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadProfilePicture(@RequestParam("file")CommonsMultipartFile fileupload,HttpSession session)
	{
		UserDetail userDetail=(UserDetail)session.getAttribute("userdetail");
		
		if(userDetail==null)
		{
			return new ResponseEntity<String>("Un-Authorised User",HttpStatus.NOT_FOUND);
		}
		else
		{
			ProfilePicture picture=new ProfilePicture();
			picture.setUsername(userDetail.getUsername());
			picture.setImage(fileupload.getBytes());
			System.out.println("I am in Do Upload Inserting Image Method");
			
			profilePictureDAO.save(picture);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	@RequestMapping(value="/getImage/{username}",method=RequestMethod.GET)
	public @ResponseBody byte[] getProfilePicture(@PathVariable("username") String username,HttpSession session)
	{
		UserDetail userDetail=(UserDetail) session.getAttribute("userdetail");
		
		if(userDetail==null)
		{
			return  null;
		}
		else
		{
			ProfilePicture picture=profilePictureDAO.getProfilePicture(userDetail.getUsername());
			
			if(picture!=null)
			{
				return picture.getImage();
			}
			else
			{
				return null;
			}
		}
	}
}
