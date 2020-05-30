package vn.mista.guitarshop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.mista.guitarshop.bo.History;
import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dao.HistoryDAO;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet(name = "history", urlPatterns = { "/history" })
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HistoryDAO historyDAO = new HistoryDAO();
		int productID = Integer.parseInt(request.getParameter("productID"));
		int idUser =  (int) session.getAttribute("curren_user");
		String fullName  =  (String) session.getAttribute("full_name");
		History history = (History) session.getAttribute("history");
		if(idUser!=0 &&history!=null) {
			history.setUserID(idUser);
			history.setFullName(fullName);
			history.setProductID(productID);
			historyDAO.insertHistory(history);
			request.setAttribute("history", history);
		}
		session.removeAttribute("history");
		
		response.sendRedirect(request.getContextPath() + "/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
