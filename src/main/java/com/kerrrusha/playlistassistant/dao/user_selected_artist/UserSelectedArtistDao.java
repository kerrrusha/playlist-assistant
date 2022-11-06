package com.kerrrusha.playlistassistant.dao.user_selected_artist;

import com.kerrrusha.playlistassistant.dao.AbstractDao;
import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.UserSelectedArtist;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserSelectedArtistDao extends AbstractDao {

	public Collection<UserSelectedArtist> findAll() throws DBException {
		Collection<UserSelectedArtist> entities = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery(Queries.SELECT_ALL_USERS_SELECTED_ARTISTS);) {
			while(rs.next()) {
				entities.add(mapToUserSelectedArtist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entities;
	}

	public Collection<UserSelectedArtist> findAllByUserId(int userId) throws DBException {
		Collection<UserSelectedArtist> entities = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.FIND_USER_SELECTED_ARTISTS_BY_USER_ID)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					entities.add(mapToUserSelectedArtist(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return entities;
	}

	public void insert(UserSelectedArtist entity) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.INSERT_USER_SELECTED_ARTIST)) {
			stmt.setInt(1, entity.getUserId());
			stmt.setString(2, entity.getArtistName());
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	public void delete(UserSelectedArtist entity) throws DBException {
		try (Connection con = DriverManager.getConnection(FULL_URL);
		     PreparedStatement stmt = con.prepareStatement(Queries.DELETE_USER_SELECTED_ARTIST)) {
			stmt.setInt(1, entity.getId());
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	private UserSelectedArtist mapToUserSelectedArtist(ResultSet rs) throws SQLException {
		UserSelectedArtist userSelectedArtist = new UserSelectedArtist();

		userSelectedArtist.setId(rs.getInt(Fields.USER_SELECTED_ARTIST_ID));
		userSelectedArtist.setUserId(rs.getInt(Fields.USER_SELECTED_ARTIST_USER_ID));
		userSelectedArtist.setArtistName(rs.getString(Fields.USER_SELECTED_ARTIST_ARTIST_NAME));

		return userSelectedArtist;
	}
}
