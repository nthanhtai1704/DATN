package udn.ute.guitarshopda.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udn.ute.guitarshopda.bo.BinhLuan;
import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.dao.BinhLuanDAO;
import udn.ute.guitarshopda.dao.SanPhamDAO;

/**
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet(name = "productInfo", urlPatterns = { "/productInfo" })
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("idSP");
		int id = Integer.parseInt(idStr);
		
		HttpSession session = request.getSession();
		session.setAttribute("idSP", id);
		SanPham sp = SanPhamDAO.getProduct1(id);
		request.setAttribute("sp", sp);
		
		ArrayList<BinhLuan> blList = BinhLuanDAO.getCommentById(id);
		request.setAttribute("blList", blList);
		if(session.getAttribute("tv") ==null) {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productinfo.jsp");
		dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productinfouser.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
