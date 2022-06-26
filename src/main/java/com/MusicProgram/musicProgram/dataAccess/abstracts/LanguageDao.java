package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.MusicLanguage;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;

public interface LanguageDao extends JpaRepository<MusicLanguage, Integer> {

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto(m.musicName, l.musicLanguage) from MusicLanguage as l inner join l.musics as m where l.musicLanguage=:languageName")
	List<Music_LanguageDto> getByMusicAndLanguage(String languageName);

	List<MusicLanguage> getByMusicLanguageContains(String musicLanguage);
}
