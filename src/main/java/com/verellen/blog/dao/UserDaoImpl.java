package com.verellen.blog.dao;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.verellen.blog.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean validateUser(User user) throws SQLException {
		boolean isAuthenticated = false;
		/*try (Connection connection = Conexion.getConnection();
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
		*/
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("user",user.getUser()))
				.add(Restrictions.eq("password",user.getPassword()));
				
			if (crit.list().isEmpty()) {
				isAuthenticated = false;
			} else if (crit.list().isEmpty() == false) {
				isAuthenticated = true;
			}
		
		return isAuthenticated;
	}

}
