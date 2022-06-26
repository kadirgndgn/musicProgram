package com.MusicProgram.musicProgram.entities.dto;

import java.io.Serializable;

public class MusicCategoryDto implements Serializable {

	private String musicName;
	private String categoryName;

	public MusicCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicCategoryDto(String musicName, String categoryName) {
		super();
		this.musicName = musicName;
		this.categoryName = categoryName;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
