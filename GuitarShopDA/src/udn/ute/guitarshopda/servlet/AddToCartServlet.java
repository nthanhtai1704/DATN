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
import udn.ute.guitarshopda.bo.GioHang;
import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.dao.BinhLuanDAO;
import udn.ute.guitarshopda.dao.GioHangDAO;
import udn.ute.guitarshopda.dao.SanPhamDAO;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet(name = "addToCart", urlPatterns = { "/addToCart" })
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idTV = (int) session.getAttribute("idTV");
		int idSP = (int) session.getAttribute("idSP");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		
		GioHang gh1 = new GioHang();
		gh1.setIdTV(idTV);
		gh1.setIdSP(idSP);
		gh1.setSoLuong(soLuong);
		
		GioHangDAO.insertGioHang(gh1);
		SanPham sp = SanPhamDAO.getProduct1(idSP);
		request.setAttribute("sp", sp);
		
		ArrayList<BinhLuan> blList = BinhLuanDAO.getCommentById(idSP);
		request.setAttribute("blList", blList);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productinfo.jsp");
		dispatcher.forward(request, response);
		/*SanPham sp = SanPhamDAO.getProduct1(idSP);
		ArrayList<GioHang> listGH = GioHangDAO.getGioHangByIdTV(idTV);
		if(gh!=null) {
			if(gh.get(1).getIdSP() == idSP) {
				gh.get(1).setSoLuong(gh.get(1).getSoLuong() + soLuong);
			}
			response.sendRedirect(request.getContextPath() + "/homeuser");
		}else {
			GioHang gh1 = new GioHang();
			gh1.setIdTV(idTV);
			gh1.setIdSP(idSP);
			gh1.setSoLuong(soLuong);
			
			GioHangDAO.insertGioHang(gh1);
			response.sendRedirect(request.getContextPath() + "/homeuser");
		}
		GioHang gh1 = new GioHang();
		if(listGH!=null) {
		for(GioHang gh:listGH ) {
			if (gh.getSp().getIdSP() == sp.getIdSP()){
				gh.setSoLuong(gh.getSoLuong()+soLuong);
				response.sendRedirect(request.getContextPath() + "/homeuser");
			}else {
				gh1.setIdTV(idTV);
				gh1.setIdSP(idSP);
				gh1.setSoLuong(soLuong);
				
				GioHangDAO.insertGioHang(gh1);
				response.sendRedirect(request.getContextPath() + "/homeuser");
			}
		}
	}else {
		gh1.setIdTV(idTV);
		gh1.setIdSP(idSP);
		gh1.setSoLuong(soLuong);
		
		GioHangDAO.insertGioHang(gh1);
		response.sendRedirect(request.getContextPath() + "/homeuser");
	}---------------
		int soLuong1 =1;
		if(session.getAttribute("idSP")!=null) {
			SanPham sp = SanPhamDAO.getProduct1(idSP);
			if(sp!=null) {
				if(request.getParameter("soLuong")!=null) {
					soLuong1= Integer.parseInt(request.getParameter("soLuong"));
				}
				HttpSession session2 = request.getSession();
				if(session2.getAttribute("gioHang")==null) {
					GioHang gioHang = new GioHang();
					gioHang.setIdSP(idSP);
					gioHang.setIdTV(idTV);
					gioHang.setSoLuong(soLuong1);
					GioHangDAO.insertGioHang(gioHang);
					session2.setAttribute("gioHang", gioHang);
				}
				else {
					GioHang gioHang = (GioHang) session2.getAttribute("gioHang");
					ArrayList<GioHang> listGH = GioHangDAO.getGioHangByIdTV(idTV);
					boolean check = false;
					for(GioHang gh : listGH) {
						if(gh.getSp().getIdSP()==sp.getIdSP()) {
							gh.setSoLuong(gh.getSoLuong() + soLuong1);
							check = true;
						}
					}
					if(check == false) {
						GioHang gioHang2 = new GioHang();
						gioHang2.setIdSP(idSP);
						gioHang2.setIdTV(idTV);
						gioHang2.setSoLuong(soLuong1);
						GioHangDAO.insertGioHang(gioHang2);
					}
					session2.setAttribute("gioHang", gioHang);
				}
			}
			response.sendRedirect(request.getContextPath() + "/homeuser");
    	}else {
    		response.sendRedirect(request.getContextPath() + "/homeuser");
		}*/
	}

}
