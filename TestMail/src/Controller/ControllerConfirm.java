package Controller;

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
public class ControllerConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cod = (String) session.getAttribute("code");
		String code1=String.valueOf(cod);
		String code = request.getParameter("number");
//		String code1 = request.getParameter("code");
		String s = "Thành Công";
		String s1= "Không Thành Công!!!";
		if(code1.equals(code)) {
			request.setAttribute("thanhcong",s);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/thanhcong.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("thanhcong",s1);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/thanhcong.jsp");
			rd.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
