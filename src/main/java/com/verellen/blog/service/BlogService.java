package com.verellen.blog.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.verellen.blog.model.BlogPost;



public interface BlogService {

	public void insertBlogPost(BlogPost post) throws SQLException;

	public BlogPost selectBlogPostById(int id);

	public List<BlogPost> selectBlogPostS();

	public void deleteBlogPost(int id) throws SQLException;
	
	public void updateBlogPost(BlogPost post) throws SQLException;
}
