package com.coll.dao;

import java.util.List;

import com.coll.model.Blog;

public interface BlogDAO 
{
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listBlog();
	
	
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	
	public boolean incLikes(Blog blog);
	public boolean incDisLikes(Blog blog);
	
}
