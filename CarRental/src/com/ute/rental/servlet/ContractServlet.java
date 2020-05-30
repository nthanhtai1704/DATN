package com.ute.rental.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.ContractRent;
import com.ute.rental.bo.Product;
import com.ute.rental.dao.ContractRentDAO;
import com.ute.rental.dao.ProductDAO;

/**
 * Servlet implementation class ContractServlet
 */
@WebServlet(name = "contract", urlPatterns = { "/contract" })
public class ContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_product"));
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProduct(id);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/createcontract.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int idproduct = Integer.parseInt(request.getParameter("idproduct"));
		int iduser = (int) session.getAttribute("id_user");
		String fullname = (String) session.getAttribute("fullname");
		String nameproduct = request.getParameter("nameproduct");
		String productspecies = request.getParameter("species");
		int quantity = Integer.parseInt(request.getParameter("acmount"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String datehire = request.getParameter("from");
		String payday = request.getParameter("to");
		int price = Integer.parseInt(request.getParameter("price"));
		int days = Integer.parseInt(request.getParameter("days"));
		int total = Integer.parseInt(request.getParameter("total"));
		
		ContractRent contract = new ContractRent();
		contract.setIdProduct(idproduct);
		contract.setIdUser(iduser);
		contract.setProductName(nameproduct);
		contract.setProductSpecies(productspecies);
		contract.setFullName(fullname);
		contract.setPrice(price);
		contract.setPhone(phone);
		contract.setAddressConsign(address);
		contract.setQuantity(quantity);
		contract.setHireDay(datehire);
		contract.setPayDay(payday);
		contract.setNumberDay(days);
		contract.setTotal(total);
		
		ContractRentDAO dao = new ContractRentDAO();
		dao.addcontract(contract);
		
		response.sendRedirect(request.getContextPath() + "/homeuser");
	}

}
																				