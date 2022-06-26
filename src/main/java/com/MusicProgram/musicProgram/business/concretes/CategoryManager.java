package com.MusicProgram.musicProgram.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MusicProgram.musicProgram.business.abstracts.CategoryService;
import com.MusicProgram.musicProgram.dataAccess.abstracts.CategoryDao;
import com.MusicProgram.musicProgram.entities.concretes.Category;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;
import com.MusicProgram.musicProgram.exception.CustomNotFoundException;
import com.MusicProgram.musicProgram.exception.CustomNotNullException;
import com.MusicProgram.musicProgram.exception.InternalServerError;
import com.MusicProgram.musicProgram.exception.NullPointerException;

@Service
public class CategoryManager implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category add(int id, Category category) {
		Optional<Category> optionalCategory = categoryDao.findById(id);
		if (optionalCategory.isPresent()) {
			return null;
		} else {
			return this.categoryDao.save(category);
		}
	}

	@Override
	@Cacheable(cacheNames = "categories")
	public List<Category> getAll() {
		return this.categoryDao.findAll();
	}

	@Override
	@Cacheable(cacheNames = "categories")
	public List<Category> getAllPageAble(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return this.categoryDao.findAll(pageable).getContent();
	}

	@Override
	@CacheEvict(cacheNames = "categories")
	public void deleteById(int id) {
		Optional<Category> category = categoryDao.findById(id);
		if (category.isPresent()) {
			this.categoryDao.deleteById(id);
		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}

	}

	@Override
	public Category update(int id, Category category) {
		Optional<Category> optionalCategory = categoryDao.findById(id);

		if (optionalCategory.isPresent()) {

			optionalCategory.get().setCategoryName(category.getCategoryName());

			if (category.getCategoryName().isBlank() || category.getCategoryName().isEmpty()) {
				throw new CustomNotNullException("Not Null");
			} else {
				return this.categoryDao.save(category);
			}

		} else {
			throw new CustomNotFoundException("Not Found Id: " + id);
		}

	}

	@Override

	public Category getByCategoryName(String categoryName) {
		if (categoryDao.getByCategoryName(categoryName).getCategoryName().isEmpty()) {
			throw new NullPointerException("Null Değer Hatası");
		} else {
			return this.categoryDao.getByCategoryName(categoryName);
		}

	}

	@Override
	public List<MusicCategoryDto> getByMusicAndCategory(String categoryName) {

		if (categoryDao.getByMusicAndCategory(categoryName).isEmpty()) {
			throw new InternalServerError("Değer Bulunamadı");
		} else {
			return this.categoryDao.getByMusicAndCategory(categoryName);
		}

	}

}
