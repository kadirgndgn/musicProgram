package com.MusicProgram.musicProgram.entities.concretes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "musics")
public class Music implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "music_id")
	private int musicId;

	@Column(name = "music_name")
	private String musicName;

	@Column(name = "music_lyrics")
	private String musicLyrics;

	@ManyToOne()
	@JoinColumn(name = "singer_id")
	private Singer singer;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private MusicLanguage musicLanguage;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "music")
	private List<Comment> comments;

	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Music(int musicId, String musicName, String musicLyrics) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.musicLyrics = musicLyrics;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicLyrics() {
		return musicLyrics;
	}

	public void setMusicLyrics(String musicLyrics) {
		this.musicLyrics = musicLyrics;
	}

}
