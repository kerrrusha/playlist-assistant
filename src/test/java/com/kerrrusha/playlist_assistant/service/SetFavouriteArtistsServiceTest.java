package com.kerrrusha.playlist_assistant.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;
import org.junit.Test;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SetFavouriteArtistsServiceTest {

	@Test
	public void artistsJsonMappingTest() {
		final String artistsJson = "[\"{\\\"name\\\":\\\"The Smashing Pumpkins\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/86b9157b38f9a2254785152a6d67f190/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Scorpions\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/e0be3d1b437f88084204c6b9b3be6600/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Frank Sinatra\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/e22ed29d34715f53323c6d190410a27c/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"The Beatles\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/895c65537c74c2014b459f73e84bccb0/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Led Zeppelin\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/abb38a8ec624344816b92e24070a4f1c/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Radiohead\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/9508c1217e880b52703a525d1bd5250c/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Mitski\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/a1c32bae74c5b58d59899ced20c61e75/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Animal Collective\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/95444a078284ad31f6b56db47cb92d51/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Guns N' Roses\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/03f76d168ad020c566273e971a0054c9/250x250-000000-80-0-0.jpg\\\"}\",\"{\\\"name\\\":\\\"Kanye West\\\",\\\"photoUrl\\\":\\\"https://e-cdns-images.dzcdn.net/images/artist/bb76c2ee3b068726ab4c37b0aabdb57a/250x250-000000-80-0-0.jpg\\\"}\"]";

		Collection<PresentableArtist> selectedArtists = JsonParser.parseString(prepareJsonString(artistsJson))
				.getAsJsonArray().asList().stream()
				.map(JsonElement::getAsJsonObject)
				.map(this::mapToPresentableArtist)
				.collect(toSet());

		assertFalse(selectedArtists.isEmpty());
	}

	private String prepareJsonString(String jsonStr) {
		return jsonStr.replaceAll("\\\\", "")
				.replaceAll("\"\\{", "{")
				.replaceAll("}\"", "}");
	}

	private PresentableArtist mapToPresentableArtist(JsonObject object) {
		PresentableArtist artist = new PresentableArtist();
		try {
			artist.setArtistName(object.get("name").getAsString());
			artist.setPhotoUrl(object.get("photoUrl").getAsString());
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		return artist;
	}
}
