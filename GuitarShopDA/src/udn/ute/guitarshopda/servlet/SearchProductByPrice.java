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
 * Servlet implementation class SearchProductByPrice
 */
@WebServlet(name = "searchByPrice", urlPatterns = { "/searchByPrice" })
public class SearchProductByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductByPrice() {
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
		String str = request .getParameter("price");
		String[] output = str.split(";");
		System.out.println(output[0]);
		System.out.println(output[1]);
		int min = Integer.parseInt(output[0]);
		int max = Integer.parseInt(output[1]);
		ArrayList<SanPham> list = SanPhamDAO.findProductByPrice(min, max);
		request.setAttribute("sPrice", list);
		if(tv==null) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/searchbyprice.jsp");
			dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/searchbypriceuser.jsp");
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
