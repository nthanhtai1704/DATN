package vn.mista.guitarshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dao.UserDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signIn.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByUsernameAndPassword(userName, password);
		System.out.println(userName);
		System.out.println(password);
		if(user == null) {
			request.setAttribute("error", "Login failed");
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/signIn.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			if(user.getRole().equals("admin")) {
				session.setAttribute("username", user.getUserName());
				session.setAttribute("role", user.getRole());
				response.sendRedirect(request.getContextPath() + "/admin");
			}else {
			session.setAttribute("username", user.getUserName());
			session.setAttribute("role", "user");
			session.setAttribute("curren_user", user.getUserID());
			session.setAttribute("curren_user1", user);
			session.setAttribute("full_name", user.getFullName());
			response.sendRedirect(request.getContextPath() + "/home");
			}
		}
		
	}

}
