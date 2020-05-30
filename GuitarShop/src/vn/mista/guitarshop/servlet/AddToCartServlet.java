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

import vn.mista.guitarshop.bo.History;
import vn.mista.guitarshop.bo.Item;
import vn.mista.guitarshop.bo.Order;
import vn.mista.guitarshop.bo.Product;
import vn.mista.guitarshop.dao.ProductDAO;
import vn.mista.guitarshop.viewbo.ProductView;
import vn.mista.guitarshop.viewutils.ProductUtils;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet(name = "addtoCart", urlPatterns = { "/addtoCart" })
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private ProductDAO productDAO;
    @Override
    public void init() throws ServletException {
    	productDAO = new ProductDAO();
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productID"));
		
		List<Integer> productList = (List<Integer>) request.getSession().getAttribute("producList");
		productList.add(productId);
		
		request.getSession().setAttribute("producList", productList);
		
		response.sendRedirect(request.getContextPath() + "/productList");
	}*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")) {
			doGetAdd(request, response);
		}*/
    	int quantity = 1;
    	int id;
    	if(request.getParameter("productID")!=null) {
    		id = Integer.parseInt(request.getParameter("productID"));
    		Product product = productDAO.getProduct(id);
    		if(product!=null) {
    			if(request.getParameter("quantity")!=null) {
    				quantity = Integer.parseInt(request.getParameter("quantity"));
    			}
    			HttpSession session = request.getSession();
    			if(session.getAttribute("order")==null) {
    				Order order = new Order();
    				History history = new History();
    				List<Item> listItems = new ArrayList<Item>();
    				Item item = new Item();
    				item.setQuantity(quantity);
    				item.setProduct(product);
    				listItems.add(item);
    				order.setItems(listItems);
    				history.setProductID(product.getProductID());
    				history.setProductName(product.getProductName());
    				history.setPrice(product.getPrice());
    				history.setQuantity(quantity);
    				session.setAttribute("order", order);
    				session.setAttribute("history", history);
    			}else {
    				Order order = (Order) session.getAttribute("order");
    				History history = (History) session.getAttribute("history");
    				List<Item> listItems = order.getItems();
    				boolean check = false;
    				for(Item item : listItems) {
    					if(item.getProduct().getProductID()==product.getProductID()) {
    						item.setQuantity(item.getQuantity() + quantity);
    						check = true;
    					}
    				}
    				if(check==false) {
    					Item item = new Item();
    					item.setQuantity(quantity);
    					item.setProduct(product);
    					listItems.add(item);
    				}
    				session.setAttribute("order", order);
    				session.setAttribute("history", history);
    			}
    		}
    		response.sendRedirect(request.getContextPath() + "/home");
    	}else {
    		response.sendRedirect(request.getContextPath() + "/home");
    	}
    	
	}
	
	/*protected void doGetAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		Product product = new Product();
		int id = Integer.parseInt(request.getParameter("productID"));
		HttpSession session = request.getSession();
		int quantity = 1;
		if(session.getAttribute("cart") == null) {
			
			ArrayList<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productDAO.getProduct(id),1));
			session.setAttribute("cart", cart);
		}else {
		}
		response.sendRedirect(request.getContextPath() + "/cart");
	}*/


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
