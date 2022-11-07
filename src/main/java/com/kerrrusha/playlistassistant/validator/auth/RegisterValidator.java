package com.kerrrusha.playlistassistant.validator.auth;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user.UserDao;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.validator.AbstractValidator;

import java.util.Collection;
import java.util.Optional;

import static com.kerrrusha.playlistassistant.util.ValidatorUtil.checkIfFieldIsNull;

public class RegisterValidator extends AbstractValidator {

	private static final String INCORRECT_LOGIN = "Login must be at least 3 characters long and must not contain spaces.";
	private static final String INCORRECT_PASSWORD = "Password must be at least 3 characters long and must not contain spaces.";
	private static final String DATABASE_ERROR = "Something is wrong with the server. We will definitely fix this, but for now, please try again.";
	private static final String LOGIN_ALREADY_EXISTS = "Such login already exists.";
	private static final String PASSWORDS_DO_NOT_MATCHES = "Passwords don't match.";
	private static final String LOGIN_IS_NULL = "Something is wrong while submitting login to the server. We will definitely fix this, but for now, please try again.";
	private static final String PASSWORD_IS_NULL = "Something is wrong while submitting password to the server. We will definitely fix this, but for now, please try again.";
	private static final String PASSWORD_REPEAT_IS_NULL = "Something is wrong while submitting password-repeat to the server. We will definitely fix this, but for now, please try again.";

	private final String login;
	private final String password;
	private final String passwordRepeat;

	public RegisterValidator(String login, String password, String passwordRepeat) {
		this.login = login;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}

	@Override
	protected void validate() {
		addPossibleError(checkIfFieldIsNull(login, LOGIN_IS_NULL));
		addPossibleError(checkIfFieldIsNull(password, PASSWORD_IS_NULL));
		addPossibleError(checkIfFieldIsNull(passwordRepeat, PASSWORD_REPEAT_IS_NULL));
		addPossibleError(validateLogin());
		addPossibleError(validatePasswords());
		addPossibleError(validateIfExists());
	}

	@Override
	public Collection<String> getErrors() {
		clearPossibleErrors();
		validate();
		return getErrorPool();
	}

	private Optional<String> validateLogin() {
		return (login.length() < 3 || login.contains(" ")) ? Optional.of(INCORRECT_LOGIN) : Optional.empty();
	}

	private Optional<String> validatePasswords() {
		if ((password.length() < 3 || password.contains(" ") || passwordRepeat.length() < 3 || passwordRepeat.contains(" "))) {
			return Optional.of(INCORRECT_PASSWORD);
		}
		return password.equals(passwordRepeat) ? Optional.empty() : Optional.of(PASSWORDS_DO_NOT_MATCHES);
	}

	private Optional<String> validateIfExists() {
		User user;

		try {
			user = new UserDao().findOneByLogin(login);
		} catch (DBException e) {
			return Optional.of(DATABASE_ERROR);
		}

		return user == null ? Optional.empty() : Optional.of(LOGIN_ALREADY_EXISTS);
	}
}
