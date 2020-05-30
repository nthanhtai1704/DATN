package udn.ute.guitarshopda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.ThanhVienDAO;
import udn.ute.guitarshopda.sendmail.EmailUtility;
import udn.ute.guitarshopda.sendmail.Random1;

/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/emailSending")
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

    public EmailSendingServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String recipient = request.getParameter("recipient");
		session.setAttribute("email", recipient);
		ThanhVien tv = ThanhVienDAO.getUserByEmail(recipient);
		if(tv!=null) {
			int code = Random1.ran();
			String s=String.valueOf(code);
			String subject = s+ " la ma khoi phuc tai khoan cua ban";
			String content =s;
			session.setAttribute("code", s);
			String resultMessage = "";
	
			try {
				EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
				resultMessage = "The e-mail was sent successfully";
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage();
			} finally {
				request.setAttribute("Message", resultMessage);
				request.setAttribute("hidden",content);
				getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp").forward(
						request, response);
			}
		}else {
			String s ="Tài khoản không tồn tại. Vui lòng kiểm tra lại!";
			request.setAttribute("thongbao", s);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/fogot.jsp");
			dispatcher.forward(request, response);
		}
	}

	}
