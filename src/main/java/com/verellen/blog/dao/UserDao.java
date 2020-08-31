package com.verellen.blog.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.verellen.blog.model.BlogPost;
import com.verellen.blog.model.User;


public interface UserDao {

	public boolean validateUser(User user) throws SQLException;

}
