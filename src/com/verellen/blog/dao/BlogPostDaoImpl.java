package com.verellen.blog.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.verellen.blog.conexion.*;
import com.verellen.blog.util.*;
import com.verellen.blog.model.BlogPost;
import com.verellen.blog.model.User;

public class BlogPostDaoImpl implements BlogPostDao {
	
	public BlogPostDaoImpl () {}

	@Override
	public void insertBlogPost(BlogPost post) throws SQLException {
		try (Connection con = Conexion.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(BlogConstantSql.INSERT_POST_SQL)) {
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2, post.getImg());
			preparedStatement.setString(3, post.getBy());
			preparedStatement.setString(4, post.getSummary());
			preparedStatement.setString(5, post.getAvion());
			preparedStatement.setString(6, post.getDate());
			preparedStatement.setString(7, post.getTags());
			preparedStatement.setString(8, post.getLocation());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	@Override
	public BlogPost selectBlogPostById(int id) {
		BlogPost post = null;
		
		try (Connection con = Conexion.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(BlogConstantSql.SELECT_POST_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				post = new BlogPost(rs.getString("title"), rs.getString("img"), rs.getString("by"),
									rs.getString("summary"), rs.getString("avion"), rs.getString("date"),
									rs.getString("tags"), rs.getString("location"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return post;
	}

	@Override
	public List<BlogPost> selectBlogPostS() {
				List<BlogPost> posts = new ArrayList<>();

				try (Connection connection = Conexion.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(BlogConstantSql.SELECT_ALL_POSTS);) {
					
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();

					while (rs.next()) {

						BlogPost post = new BlogPost();
						
						post.setBlog_id(rs.getInt("blog_id"));
						post.setTitle(rs.getString("title"));
						post.setImg(rs.getString("img"));
						post.setBy(rs.getString("by"));
						post.setSummary(rs.getString("summary"));
						post.setAvion(rs.getString("avion"));
						post.setDate(rs.getString("date"));
						post.setTags(rs.getString("tags"));
						post.setLocation(rs.getString("location"));

						posts.add(post);

					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				return posts;
	}

	@Override
	public boolean deleteBlogPost(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(BlogConstantSql.DELETE_POST_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateBlogPost(BlogPost post) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(BlogConstantSql.UPDATE_POST_BY_ID);) {
			statement.setString(1, post.getTitle());
			statement.setString(2, post.getImg());
			statement.setString(3, post.getBy());
			statement.setString(4, post.getSummary());
			statement.setString(5, post.getAvion());
			statement.setString(6, post.getDate());
			statement.setString(7, post.getTags());
			statement.setString(8, post.getLocation());
			statement.setInt   (9, post.getBlog_id());

			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
			
		}
		return rowUpdated;
	}
	
	@Override
	public boolean validateUser(User user) throws SQLException {
		boolean isAuthenticated = false;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(BlogConstantSql.VALIDATE_LOGIN)) {
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());

			System.out.println(statement);
			//isAuthenticated = statement.executeUpdate() > 0;
			
			ResultSet rs=statement.executeQuery();  
			isAuthenticated=rs.next(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAuthenticated;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
