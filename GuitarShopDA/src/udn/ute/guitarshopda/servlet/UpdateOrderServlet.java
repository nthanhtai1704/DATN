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
import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.DonHangDAO;
import udn.ute.guitarshopda.dao.ThanhVienDAO;
import udn.ute.guitarshopda.sendmail.EmailUtility;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet(name = "updateOrder", urlPatterns = { "/updateOrder" })
public class UpdateOrderServlet extends HttpServlet {
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

    public UpdateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("orderID"));
		
		DonHang dh = DonHangDAO.getOrderByID(id);
		request.setAttribute("dh", dh);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateorder.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int idDH = Integer.parseInt(request.getParameter("idDH"));
		String tinhTrang = request.getParameter("tinhTrang");
		DonHang dh1 = DonHangDAO.getOrderByID(idDH);
		
		DonHang dh = new DonHang();
		dh.setIdDH(idDH);
		dh.setTinhTrang(tinhTrang);
		
		DonHangDAO.updateOrder(idDH, tinhTrang);
		String s="Đang xử lý";
		if(dh.getTinhTrang()!=s) {
			String recipient = dh1.getEmail();
			String subject = "Cam on ban da dat hang tai GuitarShop cua chung toi!";
			String content ="Tinh trang don hang cua ban hien tai la:" + tinhTrang;
			try {
				EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath() + "/orderList");
	}

}
