package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.Singer;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;

public interface SingerDao extends JpaRepository<Singer, Integer> {

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.Music_SingerDto(m.musicName, s.singerName) from Singer as s inner join s.musics as m where s.singerName=:singerName")
	List<Music_SingerDto> getByMusicAndSinger(String singerName);

	List<Singer> getBySingerNameContains(String singerName);

	List<Singer> getBySingerNameStartsWith(String singerName);

	List<Singer> getBySingerName(String singerName);

}
