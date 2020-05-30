package com.ute.rental.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Users;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getParameter("name");
		String passwords = (String) request.getParameter("pass");

		UserDAO userdao = new UserDAO();
		Users users = userdao.findUsernameAndpasswords(username, passwords);
		if (users == null) {
			request.setAttribute("error", "Login faile");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		} else {
			if (users.getRoles().equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("userNameAdmin", users.getUsername());
				session.setAttribute("roles", users.getRoles());
				session.setAttribute("id_user", users.getIdUser());
				response.sendRedirect(request.getContextPath() + "/homeadmin");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user_current", users);
				session.setAttribute("username", users.getUsername());
				session.setAttribute("fullname", users.getNameuser());
				session.setAttribute("roles", users.getRoles());
				session.setAttribute("id_user", users.getIdUser());
				response.sendRedirect(request.getContextPath() + "/homeuser");
			}
		}
	}
}
