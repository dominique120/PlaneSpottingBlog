package com.verellen.blog.web;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogService bService =null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		bService = new BlogServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			getBlogList(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void getBlogList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<BlogPost> BlogPostList = bService.selectBlogPostS();
		
		request.setAttribute("blogPostList", BlogPostList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
