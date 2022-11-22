package com.kerrrusha.playlistassistant.service.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.service.auth.result.AuthResult;
import com.kerrrusha.playlistassistant.validator.AbstractValidator;
import com.kerrrusha.playlistassistant.validator.auth.RegisterValidator;
import org.apache.http.HttpStatus;

import java.util.Collection;

public class RegisterService {

	private static final String DATABASE_ERROR = "An error occurred on the server while creating a new user. We will definitely fix this, but for now, please try again.";
	private static final int OK_STATUS = HttpStatus.SC_OK;
	private static final int ERROR_STATUS = HttpStatus.SC_CONFLICT;

	private final String login;
	private final String password;
	private final String passwordRepeat;

	public RegisterService(String login, String password, String passwordRepeat) {
		this.login = login;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}

	public AuthResult processRegister() {
		AuthResult result = new AuthResult();
		AbstractValidator validator = new RegisterValidator(login, password, passwordRepeat);

		Collection<String> errorPool = validator.getErrors();
		if (!errorPool.isEmpty()) {
			result.setErrorPool(errorPool);
			result.setStatus(ERROR_STATUS);
			return result;
		}

		User newUser;
		try {
			newUser = addUserToDatabase();
		} catch (DBException e) {
			errorPool.add(DATABASE_ERROR);
			result.setErrorPool(errorPool);
			result.setStatus(ERROR_STATUS);
			return result;
		}

		result.setUser(newUser);
		result.setStatus(OK_STATUS);
		return result;
	}

	private User addUserToDatabase() throws DBException {
		UserDao dao = new UserDao();
		User user = new User();

		user.setLogin(login);
		user.setPassword(password);

		dao.insert(user);
		return user;
	}
}
