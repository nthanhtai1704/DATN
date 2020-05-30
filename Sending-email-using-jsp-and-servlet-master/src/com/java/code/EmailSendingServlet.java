package com.java.code;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/EmailSendingServlet")
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
    
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String recipient=request.getParameter("recipient");
String subject="Your temporary password details";//request.getParameter("subject");
//to send a link to the recipient
//String content="<a href='http://localhost:8080/EmailFacility/ForgotPassword.jsp'> Click on Link </a>";
String content="Hello! I am sending this message from a servlet ! Happy holidays." ;

/*InternetHeaders headers = new InternetHeaders();
headers.addHeader("Content-type", "text/html; charset=UTF-8");
String content = "Hi "
		+ "You have requested for a new password from our application"
		+ "<a href='http://localhost:8080/EmailFacility/Result.jsp'>Click on Link</a>";//request.getParameter("content")
try {
	MimeBodyPart body = new MimeBodyPart(headers, content.getBytes("UTF-8"));
} catch (MessagingException e1) {
	e1.printStackTrace();
}*/
String resultMessage="";

try {
	Email.sendEmail(host,port,user,pass,recipient,subject,content);
	resultMessage="The email was sent successfully";
}catch(Exception e) {
	e.printStackTrace();
	resultMessage="There is an error\t"+ e.getMessage();}
finally {
	request.setAttribute("Message", resultMessage);
	getServletContext().getRequestDispatcher("/Result.jsp").forward(request,response);
}
		
	}
}
