package com.kerrrusha.playlistassistant.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IsAuthorizedFilter implements Filter {

	public void init(FilterConfig config) {
	}

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession(false);

		boolean loggedIn = session != null && session.getAttribute("uid") != null;

		if (loggedIn) {
			chain.doFilter(request, response);
		} else {
			httpServletResponse.sendRedirect(request.getServletContext().getContextPath());
		}
	}
}
