package com.MusicProgram.musicProgram.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MusicProgram.musicProgram.entities.concretes.Category;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	@Query("Select new com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto(m.musicName, c.categoryName) from Category as c inner join c.musics as m where c.categoryName=:categoryName")
	List<MusicCategoryDto> getByMusicAndCategory(String categoryName);

	Category getByCategoryName(String categoryName);

}
