package com.kerrrusha.playlistassistant.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AbstractDao {

	protected static AbstractDao instance;

	protected String FULL_URL;

	protected AbstractDao() {
		Properties properties = new Properties();
		try (InputStream is = Files.newInputStream(Paths.get("app.properties"))) {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		FULL_URL = properties.getProperty("connection.url");
	}

	public static synchronized AbstractDao getInstance() {
		if (instance == null) {
			instance = new AbstractDao();
		}
		return instance;
	}
}
