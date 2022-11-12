package com.kerrrusha.playlistassistant.model.deezer;

import com.kerrrusha.playlistassistant.model.AbstractArtist;

public class DeezerArtist extends AbstractArtist {

	private String photoUrl;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "DeezerArtist{" +
				", photoUrl='" + photoUrl + '\'' +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
