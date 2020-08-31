package com.verellen.blog.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.verellen.blog.dao.UserDaoImpl;
import com.verellen.blog.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDao;
		
    @Transactional(readOnly = true)
	public boolean validateUser(User user) throws SQLException {
		return userDao.validateUser(user);
	}
}
