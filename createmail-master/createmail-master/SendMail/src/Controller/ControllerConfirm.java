package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Random;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Random.ran();
		String code1=String.valueOf(cod);
		String code = request.getParameter("number");
//		String code1 = request.getParameter("code");
		String s = "Thành Công";
		if(code1.equals(code)) {
			request.setAttribute("thanhcong",s);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/thanhcong.jsp");
			rd.forward(request, response);
		}
	}

}
