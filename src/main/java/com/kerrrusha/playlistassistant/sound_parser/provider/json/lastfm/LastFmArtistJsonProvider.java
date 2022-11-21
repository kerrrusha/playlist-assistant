package com.kerrrusha.playlistassistant.sound_parser.provider.json.lastfm;

import org.apache.log4j.Logger;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class LastFmArtistJsonProvider {

	static final Logger logger = Logger.getLogger(LastFmArtistJsonProvider.class);
	static final String API_KEY = "70375b3e1e3f4a5ed7f433270af4e3a2";
	static final String FIND_ARTIST_URL = String.format("https://ws.audioscrobbler.com/2.0/?method=artist.getInfo&api_key=%s&format=json", API_KEY);

	public static String getResponse(String artistId) {
		String url = FIND_ARTIST_URL + "&mbid=" + artistId;
		try {
			return getResponseString(url);
		} catch (Throwable e) {
			logger.error(e.getMessage());
			return EMPTY;
		}
	}
}
