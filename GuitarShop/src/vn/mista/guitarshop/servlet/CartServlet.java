package vn.mista.guitarshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.mista.guitarshop.bo.Product;
import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dao.ProductDAO;
import vn.mista.guitarshop.dao.UserDAO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name = "cart", urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		if(session != null && session.getAttribute("productID")!=null) {
			RequestDispatcher dispatcher = httpReq.getServletContext().
					getRequestDispatcher("/WEB-INF/views/cart.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
*/		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		super.doPost(request, response);
	}

}
