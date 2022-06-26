package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.MusicLanguage;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;

public interface LanguageService {

	MusicLanguage add(MusicLanguage musicLanguage);
	MusicLanguage update(int id, MusicLanguage musicLanguage);
	void deleteById(int id);
	
	
	List<MusicLanguage> getAllLanguage();
	List<MusicLanguage> getAllPageable(int pageNo, int pageSize);
	List<Music_LanguageDto> getByMusicAndLanguage(String languageName);
	List<MusicLanguage> getByMusicLanguageContains(String musicLanguage);
}
