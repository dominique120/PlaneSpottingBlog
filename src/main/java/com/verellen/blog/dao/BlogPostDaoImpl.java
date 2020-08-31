package com.verellen.blog.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.verellen.blog.model.BlogPost;

@Repository
public class BlogPostDaoImpl implements BlogPostDao {
	
	public BlogPostDaoImpl () {}

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertBlogPost(BlogPost post) {
		sessionFactory.getCurrentSession().saveOrUpdate(post);
		/*try (Connection con = Conexion.getConnection();
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
		}*/
	}

	public BlogPost selectBlogPostById(int id) {
		
		return (BlogPost) sessionFactory.getCurrentSession().get(
				BlogPost.class, id);
		
		/*BlogPost post = null;
		
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
		return post;*/
	}

	@SuppressWarnings("unchecked")
	public List<BlogPost> selectBlogPostS() {
		
		return sessionFactory.getCurrentSession().createQuery("from BlogPost")
				.list();
		/*		
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
				*/
	}


	public void deleteBlogPost(int id)  {
		BlogPost post = (BlogPost) sessionFactory.getCurrentSession().load(
				BlogPost.class, id);
		if (null != post) {
			this.sessionFactory.getCurrentSession().delete(post);
		}
		
		/*boolean rowDeleted;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(BlogConstantSql.DELETE_POST_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;*/
	}


	public BlogPost updateBlogPost(BlogPost post)  {
		sessionFactory.getCurrentSession().update(post);
		return post;
		
		/*boolean rowUpdated;
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
		return rowUpdated;*/
	}

}
