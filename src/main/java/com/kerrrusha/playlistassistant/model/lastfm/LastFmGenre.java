package com.kerrrusha.playlistassistant.model.lastfm;

public class LastFmGenre implements Comparable<LastFmGenre> {

	private int count;
	private String name;

	public LastFmGenre() {}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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