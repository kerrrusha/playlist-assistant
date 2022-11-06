package com.kerrrusha.playlistassistant.dao.user;

import com.kerrrusha.playlistassistant.dao.AbstractDao;
import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserDao extends AbstractDao {

	public Collection<User> findAll() throws DBException {
		Collection<User> entities = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery(Queries.SELECT_ALL_USERS);) {
			while(rs.next()) {
				entities.add(mapToUser(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entities;
	}

	public User findOneById(int id) throws DBException {
		User entity = null;
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.FIND_USER_BY_ID)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					entity = mapToUser(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entity;
	}

	public User findOneByLogin(String login) throws DBException {
		User entity = null;
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.FIND_USER_BY_LOGIN)) {
			stmt.setString(1, login);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					entity = mapToUser(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entity;
	}

	public void insert(User entity) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.INSERT_USER)) {
			stmt.setString(1, entity.getLogin());
			stmt.setString(2, entity.getPassword());
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	public void delete(User entity) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.DELETE_USER)) {
			stmt.setInt(1, entity.getId());
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	private User mapToUser(ResultSet rs) throws SQLException {
		User user = new User();

		user.setId(rs.getInt(Fields.USER_ID));
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		user.setPassword(rs.getString(Fields.USER_PASSWORD));

		return user;
	}
}
