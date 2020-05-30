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
 * Servlet implementation class SearchProductByNameServlet
 */
@WebServlet(name = "searchByName", urlPatterns = { "/searchByName" })
public class SearchProductByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ThanhVien tv = (ThanhVien) session.getAttribute("tv");
		String name = request.getParameter("productName");
		ArrayList<SanPham> sp = SanPhamDAO.findProductByName(name);
		request.setAttribute("spName", sp);
		if(tv==null) {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/searchbyname.jsp");
		dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/searchbynameuser.jsp");
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
