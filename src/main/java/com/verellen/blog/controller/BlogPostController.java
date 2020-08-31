package com.verellen.blog.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.verellen.blog.model.BlogPost;
import com.verellen.blog.service.BlogService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



@Controller
public class BlogPostController {
	
	private static final Logger logger = Logger
			.getLogger(BlogPostController.class);	
	
	@Autowired
	BlogService blogServiceImpl;
	
	BlogPostController(){}
	
	//@RequestMapping(value= "/")
	@RequestMapping({ "/", "/index" })
	public ModelAndView loadIndex(ModelAndView model) throws IOException {
		//BlogPost blogPost = new BlogPost();
		List<BlogPost> listPosts = blogServiceImpl.selectBlogPostS();
		model.addObject("blogPostList", listPosts);
		model.setViewName("index");
		return model;
	}
	
	
	@RequestMapping(value = "/loadPosts")
	public ModelAndView listPosts(ModelAndView model) throws IOException {
		List<BlogPost> listPosts = blogServiceImpl.selectBlogPostS();
		model.addObject("blogPostList", listPosts);
		model.setViewName("blogAdmin");
		return model;	
	}
	
	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	public ModelAndView newPost(@ModelAttribute BlogPost post) throws SQLException {
		blogServiceImpl.insertBlogPost(post);
		return new ModelAndView("redirect:/loadPosts");
	}
	
	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public ModelAndView savePost(@ModelAttribute BlogPost post) throws SQLException {
			blogServiceImpl.updateBlogPost(post);
		return new ModelAndView("redirect:/loadPosts");
	}
	
	@RequestMapping(value = "/editPost", method = RequestMethod.GET)
	public ModelAndView editPost(HttpServletRequest request) {
		int postId = Integer.parseInt(request.getParameter("blog_id"));
		BlogPost post = blogServiceImpl.selectBlogPostById(postId);
		ModelAndView model = new ModelAndView("post_form");
		model.addObject("post", post);
		return model;
	}
	
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	public ModelAndView deletePost(HttpServletRequest request) throws SQLException {
		int postId = Integer.parseInt(request.getParameter("blog_id"));
		blogServiceImpl.deleteBlogPost(postId);
		return new ModelAndView("redirect:/loadPosts");
	}

}
