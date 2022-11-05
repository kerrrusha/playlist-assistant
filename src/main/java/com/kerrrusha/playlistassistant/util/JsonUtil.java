package com.kerrrusha.playlistassistant.util;

import static com.kerrrusha.playlistassistant.util.SubstringUtil.substringBetween;

public class JsonUtil {

	public static String[] jsonToElements(String json) {
		String rawJson = json.replaceAll("},", "}");
		String onlyElements = substringBetween(rawJson, ":[", "]}");
		return onlyElements.split("(?<=})");
	}
}
