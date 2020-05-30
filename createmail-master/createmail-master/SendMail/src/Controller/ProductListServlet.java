package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanphamDAO;
import model.Sanpham;
import viewbo.SanphamView;
import viewutils.Sanphamutils;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet(name = "productList", urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanphamDAO dao = new SanphamDAO();
		ArrayList<Sanpham> sanpham = dao.getAllProduct();
		ArrayList<SanphamView> sanphamview = Sanphamutils.convertToProductViewList(sanpham);
		request.setAttribute("sanpham",sanphamview);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/View/productList.jsp");
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
