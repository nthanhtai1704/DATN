package com.ute.rental.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.ContractRent;
import com.ute.rental.dao.ContractRentDAO;

/**
 * Servlet implementation class ListcontractServlet
 */
@WebServlet(name = "listcontract", urlPatterns = { "/listcontract" })
@MultipartConfig(maxFileSize = 16177215)
public class ListContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContractRentDAO dao  = new ContractRentDAO();
		ArrayList<ContractRent> listcontract = dao.getAllcontract();
		request.setAttribute("listcontract", listcontract);
		RequestDispatcher dispatcher = 
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/listcontract.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}