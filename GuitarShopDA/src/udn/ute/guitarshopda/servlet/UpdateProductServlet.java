package udn.ute.guitarshopda.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.dao.SanPhamDAO;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(name = "updateProduct", urlPatterns = { "/updateProduct" })
@MultipartConfig(fileSizeThreshold = 1024 *1024*2,
maxFileSize = 1024 *1024*10,
maxRequestSize = 1024 *1024*50)
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("productID");
		int id = Integer.parseInt(idStr);
		
		SanPham sp = SanPhamDAO.getProduct(id);
		request.setAttribute("sp", sp);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateproduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("idSP");
		int id = Integer.parseInt(idStr);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Part part =  request.getPart("anh");
		String fileName = extractFileName(part);
		String savePath = "D:\\19JSP03_TT\\GuitarShopDA\\WebContent\\images" +  File.separator + fileName;
		File fileSaveDir = new File(savePath);
		part.write(savePath+ File.separator);
		
		String tenSp = request.getParameter("tenSP");
		String idLoaiStr = request.getParameter("idLoai");
		int idLoai = Integer.parseInt(idLoaiStr);
		String idHSXStr = request.getParameter("idHSX");
		int idHSX = Integer.parseInt(idHSXStr);
		String soLuongStr = request.getParameter("soLuong");
		int soLuong = Integer.parseInt(soLuongStr);
		String soLuongConStr = request.getParameter("soLuongCon");
		int soLuongCon = Integer.parseInt(soLuongConStr);
		String namSXStr = request.getParameter("namSX");
		int namSX = Integer.parseInt(namSXStr);
		String mauSac = request.getParameter("mauSac");
		String giaStr = request.getParameter("gia");
		int gia = Integer.parseInt(giaStr);
		
		SanPham sp = new SanPham();
		sp.setIdSP(id);
		sp.setTenSP(tenSp);
		sp.setIdLoai(idLoai);
		sp.setIdHSX(idHSX);
		sp.setSoLuong(soLuong);
		sp.setSoLuongCon(soLuongCon);
		sp.setNamSX(namSX);
		sp.setMauSac(mauSac);
		sp.setAnh(fileName);
		sp.setAnhDD(savePath);
		sp.setGia(gia);
		
		SanPhamDAO.updateProduct(sp);
		response.sendRedirect(request.getContextPath() + "/productList");
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
