package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.Albums;

public interface AlbumsService {

	Albums add(Albums albums);
	Albums update(int id, Albums albums);
	void delete(int id);
	
	List<Albums> getAll();
	List<Albums> getAllPageAble(int pageNo, int pageSize);
	List<Albums> getByAlbumNameContains(String albumName);
	List<Albums> getByAlbumName(String albumName);
	
}
