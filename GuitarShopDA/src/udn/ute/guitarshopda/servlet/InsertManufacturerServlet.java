package udn.ute.guitarshopda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udn.ute.guitarshopda.bo.HangSanXuat;
import udn.ute.guitarshopda.dao.HangSanXuatDAO;

/**
 * Servlet implementation class InsertManufacturerServlet
 */
@WebServlet(name = "insertHSX", urlPatterns = { "/insertHSX" })
public class InsertManufacturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertManufacturerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/createmanufacturer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenHSX = request.getParameter("tenHSX");
		HangSanXuat hsx = new HangSanXuat();
		hsx.setTenHSX(tenHSX);
		
		HangSanXuatDAO.insertHSX(hsx);
		
		response.sendRedirect(request.getContextPath() + "/manufacturerList");
	}

}
