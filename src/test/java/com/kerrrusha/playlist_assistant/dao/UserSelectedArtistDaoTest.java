package com.kerrrusha.playlist_assistant.dao;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.dao.user_selected_artist.UserSelectedArtistsDao;
import com.kerrrusha.playlistassistant.model.UserSelectedArtist;
import org.junit.Test;

import java.util.Collection;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

public class UserSelectedArtistDaoTest {

	@Test
	public void isConnectedTest() {
		assertDoesNotThrow(UserSelectedArtistsDao::new);
	}

	@Test
	public void insertDeleteTest() {
		try {
			final UserSelectedArtistsDao dao = new UserSelectedArtistsDao();

			final int userId = 3;
			final String artistName = "Slayer";
			final String artistPhotoUrl = "https://yt3.ggpht.com/ytc/AMLnZu9bNCWZSDP2yS9WWB9Kzg0LgnADmH7XsjrnCFpy=s900-c-k-c0x00ffffff-no-rj";
			final UserSelectedArtist userSelectedArtist = new UserSelectedArtist();

			userSelectedArtist.setUserId(userId);
			userSelectedArtist.setArtistName(artistName);
			userSelectedArtist.setArtistPhotoUrl(artistPhotoUrl);

			dao.deleteByUserId(userId);
			dao.insert(userSelectedArtist);

			Collection<UserSelectedArtist> userSelectedArtistFromDb = dao.findAllByUserId(userId);

			assertNotNull(userSelectedArtistFromDb);

			userSelectedArtistFromDb.forEach(elem -> {
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
			final Collection<UserSelectedArtist> artistsFound = new UserSelectedArtistsDao().findAll();
			final String select = artistsFound.stream().map(UserSelectedArtist::toString).collect(joining());

			System.out.println("Count is: " + artistsFound.size());
			System.out.println(select);

			assertFalse(select.isEmpty());

		} catch (DBException e) {
			throw new RuntimeException();
		}
	}
}
