package com.verellen.blog.util;

public class BlogConstantSql {
	
	public static final String INSERT_POST_SQL = "INSERT INTO blog (`title`, `img`, `by`, `summary`, `avion`, `date`, `tags`, `location`) "
												+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

	public static final String DELETE_POST_BY_ID = "delete from blog where blog_id = ?;";
	
	public static final String UPDATE_POST_BY_ID = "UPDATE blog SET `title` = ?, `img` = ?, `by` = ?, `summary` = ?, `avion` = ?, `date` = ?, `tags` = ?, `location` = ? WHERE (`blog_id` = ?);";
	
	public static final String SELECT_POST_BY_ID = "select * from blog where id = ?";
	public static final String SELECT_ALL_POSTS = "select * from blog";
	
	public static final String VALIDATE_LOGIN = "select * from login where user=? and password=?";
	
}
