package com.ute.rental.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Users;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet(name = "contact", urlPatterns = { "/contact" })
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/contact.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		users.setNameuser(nameuser);
		users.setIdCard(idcard);
		users.setDatebirth(datebirthStr);
		users.setAddress(address);
		users.setPhonenumber(phone);
		users.setUsername(username);
		users.setPasswords(passwords);
		users.setRoles(roles);
		
		UserDAO userdao = new UserDAO();
		userdao.AddUsers(users);
		response.sendRedirect(request.getContextPath() + "/home");	
	}
}
