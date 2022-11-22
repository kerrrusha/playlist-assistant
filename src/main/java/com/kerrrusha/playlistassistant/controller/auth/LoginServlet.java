package com.kerrrusha.playlistassistant.controller.auth;

import com.kerrrusha.playlistassistant.service.auth.AuthResultSender;
import com.kerrrusha.playlistassistant.service.auth.LoginService;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;

import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String login = request.getParameter("login");
		final String password = request.getParameter("password");

		AuthResult result = new LoginService(login, password).processLogin();
		AuthResultSender.valueOf(result).sendResponse(request, response);
	}
}
