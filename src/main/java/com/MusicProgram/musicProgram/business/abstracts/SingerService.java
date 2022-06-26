package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.Singer;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;

public interface SingerService {

	Singer add(Singer singer);
	Singer update(int id, Singer singer);
	void delete(int id);
	
	List<Singer> getAll();
	List<Singer> getAllPageAble(int pageNo, int pageSize);
	List<Singer> getBySingerName(String singerName);
	List<Singer> getBySingerNameContains(String singerName);
	List<Singer> getBySingerNameStartsWith(String singerName);
	List<Music_SingerDto> getByMusicAndSinger(String singerName);
	
}
