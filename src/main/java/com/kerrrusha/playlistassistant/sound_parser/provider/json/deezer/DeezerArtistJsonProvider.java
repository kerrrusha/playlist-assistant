package com.kerrrusha.playlistassistant.sound_parser.provider.json.deezer;
import org.apache.log4j.Logger;

import static com.kerrrusha.playlistassistant.sound_parser.http_gate.HttpGetterUtil.getResponseString;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DeezerArtistJsonProvider {

	static final Logger logger = Logger.getLogger(DeezerArtistJsonProvider.class);
	static final String BASE_URL = "https://api.deezer.com/artist/";

	public static String getResponse(String artistName) {
		final String url = BASE_URL + artistName;
		try {
			return getResponseString(url);
		} catch (Throwable e) {
			logger.error(e.getMessage());
			return EMPTY;
		}
	}
}
