package udn.ute.guitarshopda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udn.ute.guitarshopda.bo.DonHang;
import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.DonHangDAO;
import udn.ute.guitarshopda.dao.SanPhamDAO;
import udn.ute.guitarshopda.dao.ThanhVienDAO;
import udn.ute.guitarshopda.sendmail.EmailUtility;

/**
 * Servlet implementation class OrderProductServlet
 */
@WebServlet(name = "orderProduct", urlPatterns = { "/orderProduct" })
public class OrderProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

    public OrderProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idTV = (int) session.getAttribute("idTV");
		
		
		if(request.getParameter("idSP") == null) {
			int idSP = (int) session.getAttribute("idSP");
		SanPham sp = SanPhamDAO.getProduct1(idSP);
		request.setAttribute("sp", sp);}
		else {
			int idSP1 = Integer.parseInt(request.getParameter("idSP"));
		SanPham sp1 = SanPhamDAO.getProduct1(idSP1);
		request.setAttribute("sp", sp1);}
		
		ThanhVien tv = ThanhVienDAO.getUser(idTV);
		request.setAttribute("tv", tv);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderproduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idTV = (int) session.getAttribute("idTV");
		int idSP = Integer.parseInt(request.getParameter("idSP"));
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		int tt = Integer.parseInt(request.getParameter("tongTien"));
		ThanhVien tv = (ThanhVien) session.getAttribute("tv");
		if(session.getAttribute("idTV")!=null) {
			DonHang dh = new DonHang();
			dh.setIdTV(idTV);
			dh.setIdSP(idSP);
			dh.setSoLuong(soLuong);
			dh.setTongTien(tt);
			DonHangDAO.insertDH(dh);
			String recipient = tv.getEmail();
				String subject = "Cam on ban da dat hang tai GuitarShop cua chung toi!";
				String content ="Tinh trang don hang cua ban hien tai la: Đang xử lý";
				try {
					EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			request.setAttribute("thongbao", "Bạn đã đặt hàng thành công");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/message.jsp");
			dispatcher.forward(request, response);	
		}
		
		else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

}
