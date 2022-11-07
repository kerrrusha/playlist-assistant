package com.kerrrusha.playlistassistant.controller.auth;

import com.kerrrusha.playlistassistant.service.auth.AuthService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		new AuthService(request).signout();
		response.sendRedirect(getServletContext().getContextPath());
	}
}
