package Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.SanphamDAO;
import model.Sanpham;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet(name = "createProduct", urlPatterns = { "/createProduct" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize=1024*1024*10,
maxRequestSize = 1024 * 1024 * 50)
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/View/createProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		InputStream inputStream = null;
		Part  filePart  = request.getPart("image");
		if (filePart != null) {
				System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());	            
	            inputStream =    filePart.getInputStream();   
		}
		String species = request.getParameter("species");
		String quantityStr = request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityStr);
		
		Sanpham sanpham = new Sanpham();
		sanpham.setAvatar(readFile(inputStream));
		sanpham.setSpecies(species);
		sanpham.setQuantity(quantity);
		sanpham.setName(name);
		SanphamDAO dao = new SanphamDAO();
		dao.insertProduct(sanpham);
		response.sendRedirect(request.getContextPath() + "/productList");
	}
	private static byte[] readFile(InputStream inputStream) {
		ByteArrayOutputStream bos = null;
		try {
			byte[] buffer = new byte[1024];
			bos = new ByteArrayOutputStream();
			for (int len; (len = inputStream.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
			
		} catch (Exception e) {
            System.err.println(e.getMessage());
        }
		return bos.toByteArray();
	}

}
