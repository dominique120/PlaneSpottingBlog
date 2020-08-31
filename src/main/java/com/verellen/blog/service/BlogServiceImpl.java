package com.verellen.blog.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.verellen.blog.dao.BlogPostDao;
import com.verellen.blog.dao.BlogPostDaoImpl;
import com.verellen.blog.dao.BlogPostDaoImpl;
import com.verellen.blog.model.BlogPost;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogPostDao postDao;
	
	/*
	public BlogServiceImpl () {
		postDao = new BlogPostDaoImpl();
	}
*/
	@Override
	@Transactional
	public void insertBlogPost(BlogPost post) throws SQLException {
		postDao.insertBlogPost(post);
	}

	@Override
	@Transactional
	public BlogPost selectBlogPostById(int id) {
		return postDao.selectBlogPostById(id);
	}

	@Override
	@Transactional
	public List<BlogPost> selectBlogPostS() {
		return postDao.selectBlogPostS();
	}

	@Override
	@Transactional
	public void deleteBlogPost(int id) throws SQLException {
		postDao.deleteBlogPost(id);
	}
	
	@Override
	@Transactional
	public void updateBlogPost(BlogPost post) throws SQLException{
		postDao.updateBlogPost(post);
	}

}
