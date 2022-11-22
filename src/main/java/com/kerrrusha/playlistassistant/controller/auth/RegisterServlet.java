package com.kerrrusha.playlistassistant.controller.auth;

import com.kerrrusha.playlistassistant.service.auth.AuthResultSender;
import com.kerrrusha.playlistassistant.service.auth.RegisterService;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;

import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String login = request.getParameter("login");
		final String password = request.getParameter("password");
		final String passwordRepeat = request.getParameter("passwordRepeat");

		AuthResult result = new RegisterService(login, password, passwordRepeat).processRegister();
		AuthResultSender.valueOf(result).sendResponse(request, response);
	}
}
