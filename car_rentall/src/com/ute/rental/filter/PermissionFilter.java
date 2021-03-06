package com.ute.rental.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter({"/PermissionFilter","/homeadmin"})
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpSession session = httpreq.getSession();
		if(session != null
				&& session.getAttribute("roles") != null
				&& session.getAttribute("roles").equals("admin")
				&& session.getAttribute("id_user") != null) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher dispatcher = httpreq.getServletContext().getRequestDispatcher("/WEB-INF/view/homeuser.jsp");
			dispatcher.forward(request, response);		
		}			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
