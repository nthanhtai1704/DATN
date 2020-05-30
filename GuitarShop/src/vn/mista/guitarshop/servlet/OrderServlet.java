package vn.mista.guitarshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.mista.guitarshop.bo.History;
import vn.mista.guitarshop.bo.Order;
import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dao.HistoryDAO;
import vn.mista.guitarshop.dao.OrderDAO;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(name = "order", urlPatterns = { "/order" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderDAO orderDAO = new OrderDAO();
		User user =  (User) session.getAttribute("curren_user1");
		Order order = (Order) session.getAttribute("order");
		if(user!= null&&order!=null) {
			order.setCustomer(user);;
			orderDAO.insertProduct(order);
			request.setAttribute("order", order);
		}
		session.removeAttribute("order");
		
		response.sendRedirect(request.getContextPath() + "/cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
