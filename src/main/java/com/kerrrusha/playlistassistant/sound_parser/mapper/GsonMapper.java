package com.kerrrusha.playlistassistant.sound_parser.mapper;

import com.google.gson.Gson;

public abstract class GsonMapper {

	protected final Gson gson;

	public GsonMapper() {
		gson = new Gson();
	}

	public abstract Object fromJson(String jsonString);
}
