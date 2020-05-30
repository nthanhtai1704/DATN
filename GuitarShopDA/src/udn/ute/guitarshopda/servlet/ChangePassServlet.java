package udn.ute.guitarshopda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udn.ute.guitarshopda.dao.ThanhVienDAO;

/**
 * Servlet implementation class ChangePassServlet
 */
@WebServlet(name = "changePass", urlPatterns = { "/changePass" })
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassServlet() {
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
		String mkm = request.getParameter("mkm");
		String mkm1 = request.getParameter("mkm1");
		String email = (String) session.getAttribute("email");
		String s ="Mật khẩu không khớp! Vui lòng kiểm tra lại!";
		String s1 ="Thay đổi mật khẩu thành công, xin mời đăng nhập!";
		if(mkm.equals(mkm1)) {
			String mk = ThanhVienDAO.MD5(mkm);
			ThanhVienDAO.changePass(email, mk);
			request.setAttribute("thongbao",s1);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("thongbao",s);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/changepass.jsp");
			rd.forward(request, response);
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
