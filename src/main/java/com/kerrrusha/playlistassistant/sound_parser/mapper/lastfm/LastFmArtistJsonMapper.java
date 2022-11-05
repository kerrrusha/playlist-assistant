package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

public class LastFmArtistJsonMapper extends GsonMapper {

	public LastFmArtist fromJson(String jsonString) {
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		LastFmArtist artist = new LastFmArtist();

		final String id = jsonObject.get("mbid").getAsString();
		final int playcount = jsonObject.get("stats").getAsJsonObject().get("playcount").getAsInt();
		final String name = jsonObject.get("name").getAsString();
		final String url = jsonObject.get("url").getAsString();
		final Collection<LastFmArtist> similar = resolveSimilar(jsonObject);
		final Collection<LastFmGenre> genres = resolveGenres(jsonObject);

		artist.setId(id);
		artist.setPlaycount(playcount);
		artist.setName(name);
		artist.setUrl(url);
		artist.setSimilar(similar);
		artist.setGenres(genres);

		return artist;
	}

	private Collection<LastFmArtist> resolveSimilar(JsonObject jsonObject) {
		return jsonObject.get("similar").getAsJsonObject().get("artist").getAsJsonArray().asList().stream()
				.map(this::mapToSimilarArtist)
				.collect(toCollection(ArrayList<LastFmArtist>::new));
	}

	private LastFmArtist mapToSimilarArtist(JsonElement jsonElement) {
		LastFmArtist artist = new LastFmArtist();

		final String name = jsonElement.getAsJsonObject().get("name").getAsString();
		final String url = jsonElement.getAsJsonObject().get("url").getAsString();

		artist.setName(name);
		artist.setUrl(url);

		return artist;
	}

	private Collection<LastFmGenre> resolveGenres(JsonObject jsonObject) {
		return jsonObject.get("tags").getAsJsonObject().get("tag").getAsJsonArray().asList().stream()
				.map(this::mapToSimilarGenre)
				.collect(toCollection(ArrayList<LastFmGenre>::new));
	}

	private LastFmGenre mapToSimilarGenre(JsonElement jsonElement) {
		LastFmGenre genre = new LastFmGenre();

		final String name = jsonElement.getAsJsonObject().get("name").getAsString();
		genre.setName(name);

		return genre;
	}

	public String toJson(LastFmArtist artist) {
		return gson.toJson(artist);
	}

	public String jsonToId(JsonElement jsonElement) {
		try {
			return jsonElement.getAsJsonObject().get("mbid").getAsString();
		} catch(Throwable ignored) {
			return StringUtils.EMPTY;
		}
	}
}