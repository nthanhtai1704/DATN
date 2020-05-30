package udn.ute.guitarshopda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerConfirm
 */
@WebServlet("/ControllerConfirm")
public class ControllerConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConfirmServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String cod = (String) session.getAttribute("code");
		String code1=String.valueOf(cod);
		String code = request.getParameter("number");
		String s1= "Số bạn đã nhập không khớp với mã. Vui lòng thử lại!";
		if(code1.equals(code)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/changepass.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("thongbao",s1);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
			rd.forward(request, response);

		}
	}

}
