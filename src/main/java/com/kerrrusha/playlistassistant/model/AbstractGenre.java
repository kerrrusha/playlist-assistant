package com.kerrrusha.playlistassistant.model;

public class AbstractGenre implements Emptyable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isEmpty() {
		return name == null || name.isEmpty();
	}

	@Override
	public String toString() {
		return "AbstractGenre{" +
				"name='" + name + '\'' +
				'}';
	}
}
