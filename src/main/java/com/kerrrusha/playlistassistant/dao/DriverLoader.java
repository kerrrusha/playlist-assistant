package com.kerrrusha.playlistassistant.dao;

public class DriverLoader {

	public static void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
