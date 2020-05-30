package udn.ute.guitarshopda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.ThanhVienDAO;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet(name = "updateProfile", urlPatterns = { "/updateProfile" })
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("idTV");
		
		ThanhVien tv = ThanhVienDAO.getUser(id);
		request.setAttribute("profile", tv);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateprofile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("idTV");
		String hoTen = request.getParameter("hoTen");
		String sdt = request.getParameter("sdt");
		String cmnd = request.getParameter("cmnd");
		String email = request.getParameter("email");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String tenDN = request.getParameter("tenDN");
		String matKhau = request.getParameter("matKhau");
		String mk = ThanhVienDAO.MD5(matKhau);
		String quyen = "user";
		
		ThanhVien tv = new ThanhVien();
		tv.setIdTV(id);
		tv.setHoTen(hoTen);
		tv.setSdt(sdt);
		tv.setCmnd(cmnd);
		tv.setEmai(email);
		tv.setNgaySinh(ngaySinh);
		tv.setDiaChi(diaChi);
		tv.setTenDN(tenDN);
		tv.setMatKhau(mk);
		tv.setQuyen(quyen);
		
		ThanhVienDAO.updateUser(tv);
		response.sendRedirect(request.getContextPath() + "/homeuser");
	}

}
