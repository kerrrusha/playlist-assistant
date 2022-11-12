package com.kerrrusha.playlistassistant.model.presentable;

import com.kerrrusha.playlistassistant.model.AbstractArtist;

public class PresentableArtist extends AbstractArtist {

	protected String photoUrl;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "PresentableArtist{" +
				"photoUrl='" + photoUrl + '\'' +
				", artistName='" + artistName + '\'' +
				'}';
	}
}
