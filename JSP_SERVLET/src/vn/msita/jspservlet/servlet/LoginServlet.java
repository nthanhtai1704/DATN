package vn.msita.jspservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.msita.jspservlet.bo.User;
import vn.msita.jspseverlet.dao.UserDAO;

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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByUsernameAndPassword(username, password);
		/*if(user.getRole()==1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUserName());
			session.setAttribute("role", user.getRole());
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pageAdmin.jsp");
			dispatcher.forward(request, response);
		} else if(user.getRole()==2) {
			//HttpSession session = request.getSession();
			//session.setAttribute("username2", user.getUserName());
			//session.setAttribute("role2", user.getRole());
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pageUser.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("message", "Đăng nhập lỗi!!");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}*/
		
		if(user == null) {
			request.setAttribute("error", "Login failed");
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUserName());
			if(user.getRole() == 1) {
				session.setAttribute("role", "admin");
			}else {
			session.setAttribute("role", "user");
			}
			response.sendRedirect(request.getContextPath() + "/home");
		}
		
	}

}
