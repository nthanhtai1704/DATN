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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(name = "updateUser", urlPatterns = { "/updateUser" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("userID");
		int id = Integer.parseInt(idStr);
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUser(id);
		request.setAttribute("users", user);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullname");
		String tel = request.getParameter("tel");
		String idCardStr = request.getParameter("idcard");
		int idCard = Integer.parseInt(idCardStr);
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		
		User user = new User();
		user.setUserID(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setTel(tel);
		user.setIdCard(idCard);
		user.setEmail(email);
		user.setAddress(address);
		user.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.updateUser(user);
		
		response.sendRedirect(request.getContextPath() + "/userList");
	}

}
