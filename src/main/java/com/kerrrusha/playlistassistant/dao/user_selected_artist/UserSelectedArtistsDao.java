package com.kerrrusha.playlistassistant.dao.user_selected_artist;

import com.kerrrusha.playlistassistant.dao.AbstractDao;
import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_selected_artist.constant.Fields;
import com.kerrrusha.playlistassistant.dao.user_selected_artist.constant.Queries;
import com.kerrrusha.playlistassistant.model.UserSelectedArtist;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserSelectedArtistsDao extends AbstractDao {

	public UserSelectedArtistsDao() throws DBException {}

	public Collection<UserSelectedArtist> findAll() throws DBException {
		Collection<UserSelectedArtist> entities = new ArrayList<>();
		try (Connection con = dataSource.getConnection();
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery(Queries.SELECT_ALL_USER_SELECTED_ARTISTS)) {
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
		try (Connection con = dataSource.getConnection();
		     PreparedStatement stmt = con.prepareStatement(Queries.FIND_USER_SELECTED_ARTIST_BY_USER_ID)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
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
		try (Connection con = dataSource.getConnection();
		     PreparedStatement stmt = con.prepareStatement(Queries.INSERT_USER_SELECTED_ARTIST)) {
			stmt.setInt(1, entity.getUserId());
			stmt.setString(2, entity.getArtistName());
			stmt.setString(3, entity.getArtistPhotoUrl());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	public void deleteById(UserSelectedArtist entity) throws DBException {
		try (Connection con = dataSource.getConnection();
		     PreparedStatement stmt = con.prepareStatement(Queries.DELETE_USER_SELECTED_ARTIST_BY_ID)) {
			stmt.setInt(1, entity.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	public void deleteByUserId(int userId) throws DBException {
		try (Connection con = dataSource.getConnection();
		     PreparedStatement stmt = con.prepareStatement(Queries.DELETE_USER_SELECTED_ARTIST_BY_USER_ID)) {
			stmt.setInt(1, userId);
			stmt.executeUpdate();
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
		userSelectedArtist.setArtistPhotoUrl(rs.getString(Fields.USER_SELECTED_ARTIST_ARTIST_PHOTO_URL));

		return userSelectedArtist;
	}
}
