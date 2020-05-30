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
 * Servlet implementation class UpdateManufacturerServlet
 */
@WebServlet(name = "updateHSX", urlPatterns = { "/updateHSX" })
public class UpdateManufacturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManufacturerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("idHSX");
		int id = Integer.parseInt(idStr);
		
		HangSanXuat hsx = HangSanXuatDAO.getHSXByID(id);
		request.setAttribute("hsx", hsx);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updatemanufacturer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("idHSX");
		int id = Integer.parseInt(idStr);
		String tenHSX = request.getParameter("tenHSX");
		
		HangSanXuat hsx = new HangSanXuat();
		hsx.setIdHSX(id);
		hsx.setTenHSX(tenHSX);
		
		HangSanXuatDAO.updateHSX(hsx);
		
		response.sendRedirect(request.getContextPath() + "/manufacturerList");
	}

}
