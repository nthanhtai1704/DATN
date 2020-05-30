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
 * Servlet implementation class CommentServlet
 */
@WebServlet(name = "comment", urlPatterns = { "/comment" })
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int productId = (int) session.getAttribute("productId");
		int userId 	= (int) session.getAttribute("id_user");
		String fullName = (String) session.getAttribute("fullname");
		String commentStr = request.getParameter("textcomment");
		
		Comment comment = new Comment();
		comment.setIdProduct(productId);
		comment.setIdUser(userId);
		comment.setFullName(fullName);
		comment.setComment(commentStr);
		
		CommentDAO dao = new CommentDAO();
		dao.insertComment(comment);
	
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProduct(productId);		
		request.setAttribute("product", product);
		
		CommentDAO dao1 = new CommentDAO();
		ArrayList<Comment> listComment = dao.getCommentById(productId);
		request.setAttribute("listComment", listComment);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/listproductid.jsp");
		dispatcher.forward(request, response);
		
	}

}
