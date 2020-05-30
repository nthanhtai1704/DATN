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
 * Servlet implementation class SearchProductServlet
 */
@WebServlet(name = "searchProduct", urlPatterns = { "/searchProduct" })
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search");
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> productList = productDAO.findProductByName(name);
		ArrayList<ProductView> productViewList = ProductUtils.convertToProductViewList(productList);
		
		request.setAttribute("productList", productViewList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productListSearch.jsp");
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
