package com.kerrrusha.playlistassistant.factory.data;

import com.kerrrusha.playlistassistant.model.Emptyable;
import com.kerrrusha.playlistassistant.sound_parser.data.cache.SoundDataEntry;

import java.util.Collection;

public class SoundDataEntryFactory {

	public static <T extends Emptyable> SoundDataEntry<T> parse(Collection<T> elements) {
		return new SoundDataEntry<>(elements);
	}
}
