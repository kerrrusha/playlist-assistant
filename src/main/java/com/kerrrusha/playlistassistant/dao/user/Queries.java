package com.kerrrusha.playlistassistant.dao.user;

public class Queries {

	public static final String SELECT_ALL_USERS = "SELECT * FROM user";

	public static final String INSERT_USER = "INSERT INTO user(login, password) VALUES (?, ?)";

	public static final String FIND_USER_BY_ID = "SELECT * FROM USER WHERE id = ?";
	public static final String FIND_USER_BY_LOGIN = "SELECT * FROM USER WHERE LOGIN = ?";

	public static final String DELETE_USER = "DELETE FROM user where id = ?";
}
