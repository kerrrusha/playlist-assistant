package com.kerrrusha.playlistassistant.controller.auth;

import com.kerrrusha.playlistassistant.service.auth.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		new AuthService(request).signout();
		request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
	}
}
