package com.kerrrusha.playlistassistant.sound_parser.provider.json.deezer;
import org.apache.log4j.Logger;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.substringBetween;

public class DeezerArtistJsonProvider {

	static final Logger logger = Logger.getLogger(DeezerArtistJsonProvider.class);
	static final String BASE_URL = "https://api.deezer.com/artist/";
	static final String ALT_URL = "https://api.deezer.com/search?q=";

	public static String getResponse(String artistName) {
		artistName = prepareQuery(artistName);
		try {
			String response = getResponseString(BASE_URL + artistName, "_");
			if (response.contains("error")) {
				logger.info("Got an error response: " + response);
				logger.info("Trying find the artist through search request...");
				response = getResponseString(ALT_URL + artistName);
				String artistId = substringBetween(response, "\"artist\":{\"id\":", ",\"name\"");
				response = getResponseString(BASE_URL + artistId);
			}
			return response;
		} catch (Throwable e) {
			logger.error(e.getMessage());
			return EMPTY;
		}
	}

	private static String prepareQuery(String query) {
		return query.replaceAll("/", "");
	}
}
