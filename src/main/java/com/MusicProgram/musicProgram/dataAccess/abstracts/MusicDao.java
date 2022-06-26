package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.Music;
import com.MusicProgram.musicProgram.entities.dto.CommentUserMusic;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;
import com.MusicProgram.musicProgram.entities.dto.Music_Singer_CategoryDto;

public interface MusicDao extends JpaRepository<Music, Integer> {

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto(m.musicName, l.musicLanguage) from Music as m inner join m.musicLanguage as l")
	List<Music_LanguageDto> getByMusicAndLanguage();

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.Music_SingerDto(m.musicName, s.singerName) from Music as m inner join m.singer as s")
	List<Music_SingerDto> getByMusicNameAndSingerName();

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto(m.musicName, c.categoryName) from Music as m inner join m.category as c where m.musicName=:musicName")
	List<MusicCategoryDto> getByMusicAndCategory(String musicName);

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.Music_SingerDto(m.musicName, s.singerName) from Music as m inner join m.singer as s where m.musicName=:musicName")
	List<Music_SingerDto> getByMusicAndSinger(String musicName);

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.Music_Singer_CategoryDto(m.musicName, s.singerName, c.categoryName) from Singer as s inner join s.musics as m inner join m.category as c where m.musicName=:musicName")
	List<Music_Singer_CategoryDto> getByMusicSingerCategory(String musicName);

	List<Music> getByMusicNameContains(String musicName);

	List<Music> getByMusicNameStartsWith(String musicName);

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.CommentUserMusic(u.userName, m.musicName, c.comment) from User as u inner join u.comments as c inner join c.music as m")
	List<CommentUserMusic> getByMusicNameAndUserAndComment(String musicName);

}