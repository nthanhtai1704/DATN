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
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id_user");

		UserDAO userDAO = new UserDAO();
		Users users = userDAO.getUser(id);
		
		request.setAttribute("users", users);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/updateUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id_user");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nameuser = request.getParameter("name");
		String idcard =  request.getParameter("idcard");
		String datebirthStr = request.getParameter("datebirth");
		String address =  request.getParameter("address");
		String phone = request.getParameter("phone");
		String username =  request.getParameter("username");
		String passwords = request.getParameter("pass");
		String roles =  request.getParameter("roles");
		
		
		Users users = new Users();
		users.setIdUser(id);
		users.setNameuser(nameuser);
		users.setIdCard(idcard);
		users.setDatebirth(datebirthStr);
		users.setAddress(address);
		users.setPhonenumber(phone);
		users.setUsername(username);
		users.setPasswords(passwords);
		users.setRoles(roles);
		
		UserDAO userdao = new UserDAO();
		userdao.updateUser(users);
		response.sendRedirect(request.getContextPath() + "/homeuser");
	}

}
