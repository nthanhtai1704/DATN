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

import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.SanPhamDAO;

/**
 * Servlet implementation class SearchProductBySpeciesServlet
 */
@WebServlet(name = "seachBySpecies", urlPatterns = { "/seachBySpecies" })
public class SearchProductBySpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProductBySpeciesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ThanhVien tv = (ThanhVien) session.getAttribute("tv");
		String idStr = request.getParameter("idLoai");
		int id = Integer.parseInt(idStr);
		ArrayList<SanPham> sp = SanPhamDAO.findProductBySpecies(id);
		request.setAttribute("spSpecies", sp);
		if (tv == null) {
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/searchbyspecies.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/searchbyspeciesuser.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
