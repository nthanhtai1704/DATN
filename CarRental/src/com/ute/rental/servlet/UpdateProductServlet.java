package com.ute.rental.servlet;

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

import com.ute.rental.bo.Product;
import com.ute.rental.dao.ProductDAO;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(name = "updateProduct", urlPatterns = { "/updateProduct" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize=1024*1024*10,
maxRequestSize = 1024 * 1024 * 50)
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id_product");
		int id = Integer.parseInt(idStr);

		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProduct(id);
		request.setAttribute("product", product);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/updateProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idproduct");
		int id = Integer.parseInt(idStr);
		Part part = request.getPart("uploadFile");
		String fileName = extractFileName(part);
		String savePath = "E:\\19JSP03_TT\\CarRental\\WebContent\\images" + File.separator + fileName;

		File fileSaveDir = new File(savePath);
		part.write(savePath + File.separator);

		String nameproduct = request.getParameter("nameproduct");
		String species = request.getParameter("species");
		String acmountStr = request.getParameter("acmount");
		String priceStr = request.getParameter("price");
		String status = request.getParameter("status");
		int quantity = Integer.parseInt(acmountStr);
		int price = Integer.parseInt(priceStr);

		Product product = new Product();
		product.setIdproduct(id);
		product.setNameproduct(nameproduct);
		product.setSpecies(species);
		product.setQuantity(quantity);
		product.setAvatar(fileName);
		product.setAvatar_sv(savePath);
		product.setPrice(price);
		product.setStatus(status);
		
		ProductDAO dao = new ProductDAO();
		dao.updateProduct(product);
		response.sendRedirect(request.getContextPath() + "/listproduct");
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
