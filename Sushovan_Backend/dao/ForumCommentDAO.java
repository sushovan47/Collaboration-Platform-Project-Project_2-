package com.coll.dao;

import java.util.List;

import com.coll.model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addComment(ForumComment comment);
	public boolean deleteComment(ForumComment comment);
	public boolean updateComment(ForumComment comment);
	
	
	public List<ForumComment> listcomment();
	public ForumComment getComment(int commentId);

}
