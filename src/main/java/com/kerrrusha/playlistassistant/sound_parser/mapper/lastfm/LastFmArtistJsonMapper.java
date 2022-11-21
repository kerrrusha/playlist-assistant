package com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmGenre;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;
import org.apache.log4j.Logger;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

public class LastFmArtistJsonMapper extends GsonMapper {

	private static final Logger logger = Logger.getLogger(LastFmArtistJsonMapper.class);

	public LastFmArtist fromJson(String jsonString) {
		LastFmArtist artist = new LastFmArtist();
		try {
			JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject()
				.get("artist").getAsJsonObject();

			final String id = jsonObject.get("mbid").getAsString();
			artist.setId(id);

			final int playcount = jsonObject.get("stats").getAsJsonObject().get("playcount").getAsInt();
			artist.setPlaycount(playcount);

			final String name = jsonObject.get("name").getAsString();
			artist.setArtistName(name);

			final String url = jsonObject.get("url").getAsString();
			artist.setUrl(url);

			final Collection<LastFmArtist> similar = resolveSimilar(jsonObject);
			artist.setSimilar(similar);

			final Collection<LastFmGenre> genres = resolveGenres(jsonObject);
			artist.setGenres(genres);
		} catch (Throwable e) {
			logger.warn(jsonString + System.lineSeparator() + e);
		}

		return artist;
	}

	private Collection<LastFmArtist> resolveSimilar(JsonObject jsonObject) {
		return jsonObject.get("similar").getAsJsonObject().get("artist").getAsJsonArray().asList().stream()
				.map(this::mapToSimilarArtist)
				.collect(toSet());
	}

	private LastFmArtist mapToSimilarArtist(JsonElement jsonElement) {
		LastFmArtist artist = new LastFmArtist();

		final String name = jsonElement.getAsJsonObject().get("name").getAsString();
		final String url = jsonElement.getAsJsonObject().get("url").getAsString();

		artist.setArtistName(name);
		artist.setUrl(url);

		return artist;
	}

	private Collection<LastFmGenre> resolveGenres(JsonObject jsonObject) {
		return jsonObject.get("tags").getAsJsonObject().get("tag").getAsJsonArray().asList().stream()
				.map(this::mapToSimilarGenre)
				.collect(toSet());
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
}
