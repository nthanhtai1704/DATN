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
import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.BinhLuanDAO;
import udn.ute.guitarshopda.dao.SanPhamDAO;

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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ThanhVien tv = (ThanhVien) session.getAttribute("tv");
		
		if(tv!=null) {
			int idTV = tv.getIdTV();
			String hoTen = tv.getHoTen();
			int idSP = (int) session.getAttribute("idSP");
			String loiBL = request.getParameter("loiBL");
			
			BinhLuan bl = new BinhLuan();
			bl.setIdSP(idSP);
			bl.setIdTV(idTV);
			bl.setHoTen(hoTen);
			bl.setLoiBL(loiBL);
			
			BinhLuanDAO.insertComment(bl);
			
			SanPham sp = SanPhamDAO.getProduct1(idSP);
			request.setAttribute("sp", sp);
			
			ArrayList<BinhLuan> blList = BinhLuanDAO.getCommentById(idSP);
			request.setAttribute("blList", blList);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productinfo.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
