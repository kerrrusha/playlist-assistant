package com.kerrrusha.playlistassistant.controller.auth;

import com.google.gson.Gson;
import com.kerrrusha.playlistassistant.service.auth.RegisterService;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

	private final Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String login = request.getParameter("login");
		final String password = request.getParameter("password");
		final String passwordRepeat = request.getParameter("passwordRepeat");

		AuthResult result = new RegisterService(login, password, passwordRepeat).doRegister();

		String jsonResult = gson.toJson(result);
		setJsonToResponse(response, jsonResult);
	}

	private void setJsonToResponse(HttpServletResponse response, String jsonString) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonString);
		out.flush();
	}
}
