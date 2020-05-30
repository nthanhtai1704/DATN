package vn.mista.guitarshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dao.UserDAO;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(name = "signUp", urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String fullName = (String)request.getParameter("fullname");
		String tel = (String)request.getParameter("tel");
		String idCardStr = (String)request.getParameter("idcard");
		int idCard = Integer.parseInt(idCardStr);
		String email = (String)request.getParameter("email");
		String address = (String)request.getParameter("address");
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setTel(tel);
		user.setIdCard(idCard);
		user.setEmail(email);
		user.setAddress(address);
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(user);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/message.jsp");
		dispatcher.forward(request, response);
		
	}

}
