package com.verellen.blog.service;

import java.sql.SQLException;
import java.util.List;

import com.verellen.blog.model.BlogPost;
import com.verellen.blog.model.User;

public interface BlogService {

	public void insertBlogPost(BlogPost post) throws SQLException;

	public BlogPost selectBlogPostById(int id);

	public List<BlogPost> selectBlogPostS();

	public boolean deleteBlogPost(int id) throws SQLException;

	public boolean updateBlogPost(BlogPost post) throws SQLException;
	
	public boolean validateUser(User user) throws SQLException;
}
