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

import com.MusicProgram.musicProgram.business.abstracts.LanguageService;
import com.MusicProgram.musicProgram.entities.concretes.MusicLanguage;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;

@RestController
@RequestMapping("/languages/")
public class LanguagesController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("getAll")
	public ResponseEntity<List<MusicLanguage>> getAllLanguage() {
		return ResponseEntity.ok(this.languageService.getAllLanguage());
	}
	
	@GetMapping("getByMusicLanguageContains")
	public ResponseEntity<List<MusicLanguage>> getByMusicLanguageContains(@RequestParam String musicLanguage) {
		return ResponseEntity.ok(this.languageService.getByMusicLanguageContains(musicLanguage));
	}
	
	@GetMapping("getByMusicAndLanguage")
	public ResponseEntity<List<Music_LanguageDto>> getByMusicAndLanguage(@RequestParam String languageName) {
		return ResponseEntity.ok(this.languageService.getByMusicAndLanguage(languageName));
	}
	
	@GetMapping("getAllPageable")
	public ResponseEntity<List<MusicLanguage>> getAllPageable(@RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.languageService.getAllPageable(pageNo, pageSize));
	}
	
	@PostMapping("add")
	public ResponseEntity<MusicLanguage> add(@RequestBody MusicLanguage musicLanguage) {
		return ResponseEntity.ok(this.languageService.add(musicLanguage));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		languageService.deleteById(id);
		return ResponseEntity.ok("Dil başarılı bir şekilde silindi");
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<MusicLanguage> update(@PathVariable("id") int id, @RequestBody MusicLanguage musicLanguage) {
		return ResponseEntity.ok(this.languageService.update(id, musicLanguage));
	}
	
}
