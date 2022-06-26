package com.MusicProgram.musicProgram.entities.dto;

import java.io.Serializable;

public class Music_SingerDto implements Serializable {

	private String musicName;
	private String singerName;

	public Music_SingerDto() {

	}

	public Music_SingerDto(String musicName, String singerName) {
		super();
		this.musicName = musicName;
		this.singerName = singerName;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

}
