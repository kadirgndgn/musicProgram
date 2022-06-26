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
@Table(name = "mylist")
public class MyList implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "my_list_id")
	private int myListId;

	@Column(name = "music_name")
	private String musicName;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "myList")
	private List<Singer> singers;

	public MyList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyList(int myListId, String musicName) {
		super();
		this.myListId = myListId;
		this.musicName = musicName;
	}

	public int getMyListId() {
		return myListId;
	}

	public void setMyListId(int myListId) {
		this.myListId = myListId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

}
