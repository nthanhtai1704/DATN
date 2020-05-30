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
 * Servlet implementation class Login1Servlet
 */
@WebServlet(name = "login1", urlPatterns = { "/login1" })
public class Login1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/signIn.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByUsernameAndPassword(username, password);
		if(user==null) {
			request.setAttribute("error", "Login failse");
			System.out.println("ab");
		}else  {
			if(user.getRole()=="admin") {
				response.sendRedirect(request.getContextPath() + "/admin");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
	}

}
