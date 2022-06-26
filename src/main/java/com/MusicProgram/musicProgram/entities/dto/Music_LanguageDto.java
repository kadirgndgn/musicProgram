package com.MusicProgram.musicProgram.entities.dto;

import java.io.Serializable;

public class Music_LanguageDto implements Serializable {

	private String musicName;
	private String musicLanguage;

	public Music_LanguageDto() {

	}

	public Music_LanguageDto(String musicName, String musicLanguage) {
		super();
		this.musicName = musicName;
		this.musicLanguage = musicLanguage;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicLanguage() {
		return musicLanguage;
	}

	public void setMusicLanguage(String musicLanguage) {
		this.musicLanguage = musicLanguage;
	}

}
