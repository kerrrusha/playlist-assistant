package com.kerrrusha.playlistassistant.service.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;
import com.kerrrusha.playlistassistant.validator.AbstractValidator;
import com.kerrrusha.playlistassistant.validator.auth.LoginValidator;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import java.util.Collection;

public class LoginService {

	private static final Logger logger = Logger.getLogger(LoginService.class);

	private static final int OK_STATUS = HttpStatus.SC_OK;
	private static final int ERROR_STATUS = HttpStatus.SC_CONFLICT;

	private final String login;
	private final String password;

	public LoginService(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public AuthResult processLogin() {
		AuthResult result = new AuthResult();
		AbstractValidator validator = new LoginValidator(login, password);

		Collection<String> errorPool = validator.getErrors();
		if (!errorPool.isEmpty()) {
			result.setErrorPool(errorPool);
			result.setStatus(ERROR_STATUS);
			return result;
		}

		result.setStatus(OK_STATUS);
		result.setUser(getUser());
		return result;
	}

	private User getUser() {
		try {
			return new UserDao().findOneByLogin(login);
		} catch (DBException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
}
