package com.kerrrusha.playlistassistant.sound_parser.parser.lastfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kerrrusha.playlistassistant.model.AbstractGenre;
import com.kerrrusha.playlistassistant.model.lastfm.LastFmArtist;
import com.kerrrusha.playlistassistant.sound_parser.mapper.lastfm.LastFmArtistJsonMapper;
import com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.prepareTerm;
import static java.util.stream.Collectors.toCollection;

public class LastFmGenreTopArtistsParser {

	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String GENRE_TOP_TRACKS_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&api_key=%s&format=json", API_KEY);
	static final String FIND_ARTIST_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=artist.getInfo&api_key=%s&format=json", API_KEY);

	public Collection<LastFmArtist> getTopArtists(AbstractGenre genre) throws IOException {
		String artistsJson = getJsonTopArtistsByGenre(genre.getName());
		LastFmArtistJsonMapper mapper = new LastFmArtistJsonMapper();
		return jsonToElements(artistsJson).stream()
				.map(mapper::jsonToId)
				.map(this::getJsonArtistById)
				.filter(jsonStr -> jsonStr.contains("mbid"))
				.map(elem -> jsonToElement(elem).toString())
				.map(mapper::fromJson)
				.collect(toCollection(ArrayList<LastFmArtist>::new));
	}

	private String getJsonTopArtistsByGenre(String genreName) throws IOException {
		String url = GENRE_TOP_TRACKS_URL + "&tag=" + prepareTerm(genreName);
		return HttpGetterUtil.getResponseString(url);
	}

	private String getJsonArtistById(String id) {
		String url = FIND_ARTIST_URL + "&mbid=" + id;
		try {
			return HttpGetterUtil.getResponseString(url);
		} catch (IOException e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		}
	}

	private static Collection<JsonElement> jsonToElements(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.getAsJsonObject("topartists").get("artist").getAsJsonArray().asList();
	}

	private static JsonElement jsonToElement(String json) {
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		return jsonObject.get("artist");
	}
}
