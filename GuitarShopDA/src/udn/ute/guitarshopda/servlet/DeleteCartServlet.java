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

import udn.ute.guitarshopda.bo.GioHang;
import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.GioHangDAO;
import udn.ute.guitarshopda.dao.ThanhVienDAO;

/**
 * Servlet implementation class deleteCartServlet
 */
@WebServlet(name = "deleteCart", urlPatterns = { "/deleteCart" })
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int idGH = Integer.parseInt(request.getParameter("idGH"));
		GioHangDAO.deleteGioHang(idGH);
		
		
		HttpSession session = request.getSession();
		int idTV = (int) session.getAttribute("idTV");
		ArrayList<GioHang> listGH = GioHangDAO.getGioHangByIdTV(idTV);
		request.setAttribute("listGH", listGH);
		request.setAttribute("listGH1", listGH);
		
		ThanhVien tv = ThanhVienDAO.getUser(idTV);
		request.setAttribute("tv", tv);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp");
		dispatcher.forward(request, response);
	}	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
