package com.coll.dao;

import java.util.List;

import com.coll.model.BlogComment;
/**
 * BlogCommentDAO comment added fot git commit testing
 */

public interface BlogCommentDAO 
{
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> listBlogComment(int blogId);

}
