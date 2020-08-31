package com.verellen.blog.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.*;

import com.verellen.blog.model.User;
import com.verellen.blog.service.BlogService;
import com.verellen.blog.service.BlogServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		blogService = new BlogServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(email, password);

		if (isValidEmailAddress(email) == false) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("InvalidInput.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
		if (blogService.validateUser(user)) {
			response.sendRedirect("BlogPostServlet?operation=list");

			HttpSession session = request.getSession();
			session.setAttribute("usuario", user.getUserName());

			session.setMaxInactiveInterval(30 * 60);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("InvalidInput.jsp");
			dispatcher.forward(request, response);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
/*
		if (email.equals("admin@mail.com") && password.equals("123456")) {
			response.sendRedirect("BlogPostServlet?operation=list");

			HttpSession session = request.getSession();
			session.setAttribute("usuario", "Juan Huarca");
			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30 * 60);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("InvalidInput.jsp");
			dispatcher.forward(request, response);
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern p = Pattern.compile(ePattern);
		Matcher m = p.matcher(email);
		return m.matches();
	}

}
