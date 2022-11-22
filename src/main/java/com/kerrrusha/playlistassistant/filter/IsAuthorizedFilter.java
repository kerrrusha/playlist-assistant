package com.kerrrusha.playlistassistant.filter;

import com.kerrrusha.playlistassistant.model.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IsAuthorizedFilter implements Filter {

	private static final Logger logger = Logger.getLogger(IsAuthorizedFilter.class);

	public void init(FilterConfig config) {
	}

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession(false);

		boolean loggedIn = (session != null && session.getAttribute("user") != null);

		if (loggedIn) {
			User user = (User) session.getAttribute("user");
			logger.info("New authorized request from user.id = " + user.getId());
			chain.doFilter(request, response);
		} else {
			logger.info("New non-authorized request");
			httpServletResponse.sendRedirect(request.getServletContext().getContextPath());
		}
	}
}
