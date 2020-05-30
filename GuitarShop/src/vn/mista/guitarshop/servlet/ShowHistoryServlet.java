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
import vn.mista.guitarshop.bo.Order;
import vn.mista.guitarshop.dao.HistoryDAO;
import vn.mista.guitarshop.dao.OrderDAO;

/**
 * Servlet implementation class ShowHistoryServlet
 */
@WebServlet(name = "showhistory", urlPatterns = { "/showhistory" })
public class ShowHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HistoryDAO historyDAO = new HistoryDAO();
		HttpSession session = request.getSession();
		int idUser = (int) session.getAttribute("curren_user");
		ArrayList<History> listHistory = historyDAO.getAllHistoryUser(idUser);
		request.setAttribute("listHistory" , listHistory);
		/*OrderDAO orderDAO = new OrderDAO();
		ArrayList<Order> listOrder = orderDAO.getAllOrder();
		*/
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/history.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
