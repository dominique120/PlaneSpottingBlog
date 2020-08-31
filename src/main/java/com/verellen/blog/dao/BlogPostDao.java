package com.verellen.blog.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.verellen.blog.model.*;


public interface BlogPostDao {

	public void insertBlogPost(BlogPost post) throws SQLException;

	public BlogPost selectBlogPostById(int id);

	public List<BlogPost> selectBlogPostS();

	public void deleteBlogPost(int id) throws SQLException;
	
	public BlogPost updateBlogPost(BlogPost post) throws SQLException;
	
}
