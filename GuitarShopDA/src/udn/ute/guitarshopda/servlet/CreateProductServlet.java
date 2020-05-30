package udn.ute.guitarshopda.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.dao.SanPhamDAO;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet(name = "createproduct", urlPatterns = { "/createproduct" })
@MultipartConfig(fileSizeThreshold = 1024 *1024*2,
maxFileSize = 1024 *1024*10,
maxRequestSize = 1024 *1024*50)
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/createproduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Part part =  request.getPart("anh");
		String fileName = extractFileName(part);
		String savePath = "D:\\19JSP03_TT\\GuitarShopDA\\WebContent\\images" +  File.separator + fileName;
		File fileSaveDir = new File(savePath);
		part.write(savePath+ File.separator);
		
		String tenSp = request.getParameter("tenSp");
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
		String moTa = request.getParameter("moTa");
		
		SanPham sp = new SanPham();
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
		sp.setMoTa(moTa);
		
		SanPhamDAO.insertProduct(sp);
		
		response.sendRedirect(request.getContextPath() + "/productList");
		
	}
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
}

}
