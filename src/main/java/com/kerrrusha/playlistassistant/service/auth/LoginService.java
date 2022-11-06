package com.kerrrusha.playlistassistant.service.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;
import com.kerrrusha.playlistassistant.validator.Validator;
import com.kerrrusha.playlistassistant.validator.auth.LoginValidator;
import org.apache.http.HttpStatus;

import java.util.Collection;

public class LoginService {

	private static final String DATABASE_ERROR = "An error occurred on the server. We will definitely fix this, but for now, please try again.";
	private static final int OK_STATUS = HttpStatus.SC_OK;
	private static final int ERROR_STATUS = HttpStatus.SC_CONFLICT;

	private final String login;
	private final String password;

	public LoginService(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public AuthResult doLogin() {
		AuthResult result = new AuthResult();
		Validator validator = new LoginValidator(login, password);

		Collection<String> errorPool = validator.getErrors();
		if (!errorPool.isEmpty()) {
			result.setErrorPool(errorPool);
			result.setStatus(ERROR_STATUS);
			return result;
		}

		result.setStatus(OK_STATUS);
		return result;
	}
}
