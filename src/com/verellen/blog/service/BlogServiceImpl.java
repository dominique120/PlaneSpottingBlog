package com.verellen.blog.service;

import java.sql.SQLException;
import java.util.List;

import com.verellen.blog.dao.BlogPostDao;
import com.verellen.blog.dao.BlogPostDaoImpl;
import com.verellen.blog.model.BlogPost;
import com.verellen.blog.model.User;

public class BlogServiceImpl implements BlogService {
	
	private BlogPostDao postDao;
	
	public BlogServiceImpl () {
		postDao = new BlogPostDaoImpl();
	}

	@Override
	public void insertBlogPost(BlogPost post) throws SQLException {
		postDao.insertBlogPost(post);
	}

	@Override
	public BlogPost selectBlogPostById(int id) {
		return postDao.selectBlogPostById(id);
	}

	@Override
	public List<BlogPost> selectBlogPostS() {
		return postDao.selectBlogPostS();
	}

	@Override
	public boolean deleteBlogPost(int id) throws SQLException {
		return postDao.deleteBlogPost(id);
	}

	@Override
	public boolean updateBlogPost(BlogPost post) throws SQLException {
		return postDao.updateBlogPost(post);
	}
	
	@Override
	public boolean validateUser(User user) throws SQLException {
		return postDao.validateUser(user);
	}

}
