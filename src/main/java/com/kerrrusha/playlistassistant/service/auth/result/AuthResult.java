package com.kerrrusha.playlistassistant.service.auth.result;

import java.util.Collection;

public class AuthResult {

	private Collection<String> errorPool;
	private int status;
	private int userId;

	public AuthResult() {
		userId = -1;
	}

	public Collection<String> getErrorPool() {
		return errorPool;
	}

	public void setErrorPool(Collection<String> errorPool) {
		this.errorPool = errorPool;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isOK() {
		return status == 200;
	}
}
