package com.MusicProgram.musicProgram.entities.dto;

import java.io.Serializable;

public class Music_Singer_CategoryDto implements Serializable {

	private String musicName;
	private String singerName;
	private String categoryName;

	public Music_Singer_CategoryDto() {

	}

	public Music_Singer_CategoryDto(String musicName, String singerName, String categoryName) {
		super();
		this.musicName = musicName;
		this.singerName = singerName;
		this.categoryName = categoryName;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
