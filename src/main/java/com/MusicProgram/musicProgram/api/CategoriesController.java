package com.MusicProgram.musicProgram.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MusicProgram.musicProgram.business.abstracts.CategoryService;
import com.MusicProgram.musicProgram.entities.concretes.Category;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;

@RestController
@RequestMapping("/categories/")
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("getAll")
	public ResponseEntity<List<Category>> getAll() {
		return ResponseEntity.ok(this.categoryService.getAll());
	}
	
	@PostMapping("add/{id}")
	public ResponseEntity<Category> add(@PathVariable("id") int id, @RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.add(id, category));
	}
	
	@GetMapping("pageAble")
	public ResponseEntity<List<Category>> getAllPageAble(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.categoryService.getAllPageAble(pageNumber, pageSize));
	}
	
	@GetMapping("getByCategoryName")
	public ResponseEntity<Category> getByCategoryName(@RequestParam String categoryName) {
		return ResponseEntity.ok(this.categoryService.getByCategoryName(categoryName));
	}
	
	@GetMapping("getByMusicAndCategory")
	public ResponseEntity<List<MusicCategoryDto>> getByMusicAndCategory(@RequestParam String categoryName) {
		return ResponseEntity.ok(this.categoryService.getByMusicAndCategory(categoryName));
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.update(id, category));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		categoryService.deleteById(id);
		return ResponseEntity.ok("Kategori başarıyla silinmiştir.");
	}
	
}
