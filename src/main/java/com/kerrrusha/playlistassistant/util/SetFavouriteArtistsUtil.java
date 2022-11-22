package com.kerrrusha.playlistassistant.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.presentable.PresentableArtist;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class SetFavouriteArtistsUtil {

	public static Collection<PresentableArtist> mapJsonToPresentableArtists(String jsonArtists) {
		return JsonParser.parseString(prepareJsonString(jsonArtists))
				.getAsJsonArray().asList().stream()
				.map(JsonElement::getAsJsonObject)
				.map(SetFavouriteArtistsUtil::mapToPresentableArtist)
				.collect(toSet());
	}

	private static String prepareJsonString(String jsonStr) {
		return jsonStr.replaceAll("\\\\", "")
				.replaceAll("\"\\{", "{")
				.replaceAll("}\"", "}");
	}

	private static PresentableArtist mapToPresentableArtist(JsonObject object) {
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
