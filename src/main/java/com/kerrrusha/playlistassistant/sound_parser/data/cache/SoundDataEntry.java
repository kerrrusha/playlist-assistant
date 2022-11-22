package com.kerrrusha.playlistassistant.sound_parser.data.cache;

import com.kerrrusha.playlistassistant.model.Emptyable;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class SoundDataEntry <T extends Emptyable> extends ArrayList<T> {

	public SoundDataEntry() {}

	public SoundDataEntry(Collection<T> elements) {
		super(elements);
	}

	public int removeEmptyValues() {
		int startSize = size();

		SoundDataEntry<T> result = stream()
				.filter(elem -> !elem.isEmpty())
				.collect(toCollection(SoundDataEntry::new));
		clear();
		addAll(result);

		return startSize - size();
	}

	public Collection<T> shuffle() {
		List<T> shuffledList = new ArrayList<>(this);
		Collections.shuffle(shuffledList);
		return shuffledList;
	}
}
