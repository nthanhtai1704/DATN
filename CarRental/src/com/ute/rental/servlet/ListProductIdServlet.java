package com.ute.rental.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Comment;
import com.ute.rental.bo.Product;
import com.ute.rental.dao.CommentDAO;
import com.ute.rental.dao.ProductDAO;

/**
 * Servlet implementation class ListProductIdServlet
 */
@WebServlet(name = "listProductid", urlPatterns = { "/listProductid" })
public class ListProductIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id_product");
		int id = Integer.parseInt(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("productId", id);
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProduct(id);
		request.setAttribute("product", product);

		CommentDAO dao = new CommentDAO();
		ArrayList<Comment> listComment = dao.getCommentById(id);
		request.setAttribute("listComment", listComment);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/listproductid.jsp");
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
