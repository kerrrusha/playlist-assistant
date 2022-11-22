package com.kerrrusha.playlist_assistant.service;

import com.kerrrusha.playlistassistant.dao.DBException;
import com.kerrrusha.playlistassistant.model.User;
import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.service.PlaylistProvider;
import org.junit.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistProviderTest extends PlaylistProvider {

	@Test
	public void collectsTracksTest() {
		final User user = new User();
		user.setId(2);
		user.setLogin("asd");

		final Collection<ItunesTrack> tracks;
		try {
			tracks = getUserPlaylist(user);
		} catch (DBException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Collected " + tracks.size() + " tracks.");

		assertTrue(tracks.size() > 1);
	}
}
