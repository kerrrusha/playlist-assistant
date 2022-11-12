package com.kerrrusha.playlistassistant.model.lastfm;

import com.kerrrusha.playlistassistant.model.AbstractGenre;

public class LastFmGenre extends AbstractGenre implements Comparable<LastFmGenre> {

	private int count;

	public LastFmGenre() {}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(LastFmGenre o) {
		return Integer.compare(getCount(), o.getCount());
	}

	@Override
	public String toString() {
		return String.format("LastFmGenre [\n" +
						"count = %s\n" +
						"name = %s\n" +
						"]",
				getCount(),
				getName());
	}
}