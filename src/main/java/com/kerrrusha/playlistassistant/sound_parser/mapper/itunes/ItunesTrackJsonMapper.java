package com.kerrrusha.playlistassistant.sound_parser.mapper.itunes;

import com.kerrrusha.playlistassistant.model.itunes.ItunesTrack;
import com.kerrrusha.playlistassistant.sound_parser.mapper.GsonMapper;

public class ItunesTrackJsonMapper extends GsonMapper {

	public ItunesTrack fromJson(String jsonString) {
		return gson.fromJson(jsonString, ItunesTrack.class);
	}

	public String songToJson(ItunesTrack song) {
		return gson.toJson(song);
	}
}
