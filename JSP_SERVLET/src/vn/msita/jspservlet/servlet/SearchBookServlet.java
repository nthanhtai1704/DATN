package vn.msita.jspservlet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.msita.jspservlet.bo.Book;
import vn.msita.jspseverlet.dao.BookDAO;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet(name = "searchBook", urlPatterns = { "/searchBook" })
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get data from database Mysql
				BookDAO bookDAO = new BookDAO();
				String name = request.getParameter("search");
				ArrayList<Book> bookList = bookDAO.findBookByName(name);
				
				//Forward to book list view
				request.setAttribute("bookList", bookList);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/booklist.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
