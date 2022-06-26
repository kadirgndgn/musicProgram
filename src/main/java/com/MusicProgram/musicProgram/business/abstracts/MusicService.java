package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.Music;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;
import com.MusicProgram.musicProgram.entities.dto.Music_Singer_CategoryDto;

public interface MusicService {

	Music add(Music music);
	void deleteById(int id);
	Music update(int id, Music music);
	
	List<Music> getAll();
	List<Music> getAllPageable(int pageSize, int pageNumber);
	List<Music_SingerDto> getByMusicNameAndSingerName();
	
	List<MusicCategoryDto> getByMusicAndCategory(String musicName);
	List<Music_SingerDto> getByMusicAndSinger(String musicName);
	List<Music> getByMusicNameStartsWith(String musicName);
	
	List<Music> getByMusicNameContains(String musicName);	
	List<Music_Singer_CategoryDto> getByMusicSingerCategory(String musicName);
	List<Music_LanguageDto> getByMusicAndLanguage();
	
}
