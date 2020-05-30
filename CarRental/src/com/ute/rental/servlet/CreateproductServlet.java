package com.ute.rental.servlet;

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

import com.ute.rental.bo.Product;
import com.ute.rental.dao.ProductDAO;

/**
 * Servlet implementation class CreateproductServlet
 */
@WebServlet(name = "createproduct", urlPatterns = { "/createproduct" })
@MultipartConfig(fileSizeThreshold = 1024 *1024*2,
maxFileSize = 1024 *1024*10,
maxRequestSize = 1024 *1024*50)
public class CreateproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateproductServlet() {
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
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/createproduct.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Part part =  request.getPart("uploadFile");
		String fileName = extractFileName(part);
		String savePath = "E:\\19JSP03_TT\\CarRental\\WebContent\\images" +  File.separator + fileName;
	
		File fileSaveDir = new File(savePath);
		part.write(savePath+ File.separator);
		
		String nameproduct = request.getParameter("nameproduct");
		String species = request.getParameter("species");
		String acmountStr = request.getParameter("acmount");
		String priceStr = request.getParameter("price");
		String status = request.getParameter("status");
		int quantity = Integer.parseInt(acmountStr);
		int price = Integer.parseInt(priceStr);
		
		Product product = new Product();
		product.setNameproduct(nameproduct);
		product.setSpecies(species);
		product.setQuantity(quantity);
		product.setAvatar(fileName);
		product.setAvatar_sv(savePath);
		product.setPrice(price);	
		product.setStatus(status);
		
		ProductDAO dao = new ProductDAO();
		dao.AddPt(product);
		response.sendRedirect(request.getContextPath() + "/listproduct");	
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
