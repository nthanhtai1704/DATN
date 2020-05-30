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
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String pass1 = ThanhVienDAO.MD5(pass);
		ThanhVien user = ThanhVienDAO.findUserByUsernameAndPassword(username, pass1);
		if(user == null) {
			request.setAttribute("thongbao", "Đăng nhập thất bại, vui lòng kiểm tra lại!");
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			if(user.getQuyen().equals("admin")) {
				session.setAttribute("username", user.getTenDN());
				session.setAttribute("role", user.getQuyen());
				response.sendRedirect(request.getContextPath() + "/admin");
			}else {
			session.setAttribute("username", user.getTenDN());
			session.setAttribute("role", "user");
			session.setAttribute("idTV", user.getIdTV());
			session.setAttribute("tv", user);
			session.setAttribute("full_name", user.getHoTen());
			response.sendRedirect(request.getContextPath() + "/homeuser");
			}
		}
	}

}
