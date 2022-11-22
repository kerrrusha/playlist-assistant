package com.kerrrusha.playlist_assistant.dao;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_suitable_track.UserSuitableTrackDao;
import com.kerrrusha.playlistassistant.model.UserSuitableTrack;
import org.junit.Test;

import java.util.Collection;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserSuitableTrackDaoTest {

	@Test
	public void isConnectedTest() {
		assertDoesNotThrow(UserSuitableTrackDao::new);
	}

	@Test
	public void insertDeleteTest() {
		try {
			final UserSuitableTrackDao dao = new UserSuitableTrackDao();

			final int userId = 3;
			final String artistName = "Metallica";
			final String trackName = "Enter Sandman";
			final String trackPhotoUrl = "https://upload.wikimedia.org/wikipedia/ru/6/6f/Enter_Sansman.jpg";
			final UserSuitableTrack userSuitableTrack = new UserSuitableTrack();

			userSuitableTrack.setUserId(userId);
			userSuitableTrack.setArtistName(artistName);
			userSuitableTrack.setTrackName(trackName);
			userSuitableTrack.setTrackPhotoUrl(trackPhotoUrl);

			dao.deleteByUserId(userId);
			dao.insert(userSuitableTrack);

			Collection<UserSuitableTrack> userSuitableTracksFromDb = dao.findAllByUserId(userId);

			assertNotNull(userSuitableTracksFromDb);

			userSuitableTracksFromDb.forEach(elem -> {
				try {
					dao.deleteById(elem);
				} catch (DBException e) {
					throw new RuntimeException(e);
				}
			});

			assertTrue(dao.findAllByUserId(userId).isEmpty());

		} catch (DBException e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void findAllTest() {
		try {
			final Collection<UserSuitableTrack> tracksFound = new UserSuitableTrackDao().findAll();
			final String select = tracksFound.stream()
					.map(UserSuitableTrack::toString)
					.collect(joining(System.lineSeparator()));

			System.out.println("Count is: " + tracksFound.size());
			System.out.println(select);

			assertFalse(select.isEmpty());

		} catch (DBException e) {
			throw new RuntimeException();
		}
	}
}
