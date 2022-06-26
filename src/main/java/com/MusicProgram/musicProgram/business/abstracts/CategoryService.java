package com.MusicProgram.musicProgram.business.abstracts;

import java.util.List;

import com.MusicProgram.musicProgram.entities.concretes.Category;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;

public interface CategoryService {
	
	Category add(int id, Category category);
	Category update(int id, Category category);
	void deleteById(int id);
	
	Category getByCategoryName(String categoryName);	
	List<Category> getAll();
	List<MusicCategoryDto> getByMusicAndCategory(String categoryName);
	List<Category> getAllPageAble(int pageNumber, int pageSize);

}
