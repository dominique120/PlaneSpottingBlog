package com.verellen.blog.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.verellen.blog.model.BlogPost;
import com.verellen.blog.service.BlogService;
import com.verellen.blog.service.BlogServiceImpl;

/**
 * Servlet implementation class BlogPostServlet
 */
@WebServlet("/blogPostServlet")
public class BlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogService blogService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		blogService = new BlogServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("operation");

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertPost(request, response);
				break;
			case "delete":
				deletePost(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updatePost(request, response);
				break;
			default:
				listBlogPosts(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBlogPosts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<BlogPost> BlogPostList = blogService.selectBlogPostS();

		request.setAttribute("blogPostList", BlogPostList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogAdmin.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BlogPost post = blogService.selectBlogPostById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogAdmin.jsp");
		request.setAttribute("post", post);
		dispatcher.forward(request, response);

	}

	private void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		BlogPost post = new BlogPost(
				request.getParameter("txtTituloNew"), 
				request.getParameter("txtImgNew"),
				request.getParameter("txtByNew"),
				request.getParameter("txtResumenNew"),
				request.getParameter("txtAvionNew"),
				request.getParameter("txtFechaNew"),
				request.getParameter("txtTagsNew"),
				request.getParameter("txtLugarNew")
									);
		
		blogService.insertBlogPost(post);
		response.sendRedirect("admin?operation=list");
	}

	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, NumberFormatException, ParseException {

		System.out.println(request.getParameter("txtFechaAct"));
		BlogPost post = new BlogPost(
				Integer.parseInt(request.getParameter("txtIdAct")),
				request.getParameter("txtTituloAct"), 
				request.getParameter("txtImgAct"),
				request.getParameter("txtByAct"),
				request.getParameter("txtResumenAct"),
				request.getParameter("txtAvionAct"),
				request.getParameter("txtFechaAct"),
				request.getParameter("txtTagsAct"),
				request.getParameter("txtLugarAct")
				);

		blogService.updateBlogPost(post);
		response.sendRedirect("admin?operation=list");
	}

	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		blogService.deleteBlogPost(id);
		response.sendRedirect("admin?operation=list");

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

}
