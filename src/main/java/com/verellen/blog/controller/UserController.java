package com.verellen.blog.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verellen.blog.model.User;
import com.verellen.blog.service.UserService;



@Controller
public class UserController {
	private static final Logger logger = Logger
			.getLogger(UserController.class);
	
	public UserController() {}
	
	@Autowired
	UserService userServiceImpl;
	
	@RequestMapping(value = "/login")
	public ModelAndView loadLogin(ModelAndView model) throws IOException {
		User user = new User();

		model.addObject("user", user);
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/loginSend")
	public ModelAndView loadLogin(@ModelAttribute User user) throws IOException, SQLException {
		boolean isValidUser = userServiceImpl.validateUser(user);

		if(isValidUser == false) {
			ModelAndView model = new ModelAndView("InvalidInput");
			return model;
		} else {
			ModelAndView mav = new ModelAndView("redirect:/loadPosts");
			return mav;
		}
	}
}
