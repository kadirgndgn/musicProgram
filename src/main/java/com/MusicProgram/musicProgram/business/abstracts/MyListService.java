package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.MyList;

public interface MyListService {

	MyList add(MyList myList);
	void deleteById(int id);
	MyList update(int id, MyList myList);
	
	List<MyList> getAllMyList();
	List<MyList> getByPageable(int pageNo, int pageSize);
	List<MyList> getByMusicName(String musicName);
	List<MyList> getByMusicNameStartsWith(String musicName);
	List<MyList> getByMusicNameContains(String musicName);
	
}
