package vn.mista.guitarshop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.mista.guitarshop.bo.Product;
import vn.mista.guitarshop.dao.ProductDAO;
import vn.mista.guitarshop.viewbo.ProductView;
import vn.mista.guitarshop.viewutils.ProductUtils;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(name = "home", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> productList = productDAO.getAllProduct();
		ArrayList<ProductView> productViewList = ProductUtils.convertToProductViewList(productList);
		
		request.setAttribute("productList", productViewList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homepage.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
