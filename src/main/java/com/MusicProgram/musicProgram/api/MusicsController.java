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

import com.MusicProgram.musicProgram.business.abstracts.MusicService;
import com.MusicProgram.musicProgram.entities.concretes.Music;
import com.MusicProgram.musicProgram.entities.dto.MusicCategoryDto;
import com.MusicProgram.musicProgram.entities.dto.Music_LanguageDto;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;
import com.MusicProgram.musicProgram.entities.dto.Music_Singer_CategoryDto;

@RestController
@RequestMapping("/music")
public class MusicsController {

	
	private MusicService musicService;
	
	@Autowired
	public MusicsController(MusicService musicService) {
		super();
		this.musicService = musicService;
	}

	@PostMapping("/add")
	public ResponseEntity<Music> add(@RequestBody Music music) {
		return ResponseEntity.ok(this.musicService.add(music));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Music>> getAll() {
		return ResponseEntity.ok(this.musicService.getAll());
	}
	
	@GetMapping("/getByMusicAndCategory")
	public ResponseEntity<List<MusicCategoryDto>> getByMusicAndCategory(@RequestParam String musicName) {
		return ResponseEntity.ok(this.musicService.getByMusicAndCategory(musicName));
	}
	
	@GetMapping("/getAllPageable")
	public ResponseEntity<List<Music>> getAllPageable(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.musicService.getAllPageable(pageNumber, pageSize));
	}
	
	@GetMapping("/getByMusicSingerCategory")
	public ResponseEntity<List<Music_Singer_CategoryDto>> getByMusicSingerCategory(@RequestParam String musicName) {
		return ResponseEntity.ok(this.musicService.getByMusicSingerCategory(musicName));
	}
	
	@GetMapping("/getByMusicNameStartsWith")
	public ResponseEntity<List<Music>> getByMusicNameStartsWith(@RequestParam String musicName) {
		return ResponseEntity.ok(this.musicService.getByMusicNameStartsWith(musicName));
	}
	
	
	@GetMapping(value =  "/getByMusicNameContains")
	public ResponseEntity<List<Music>> getByMusicNameContains(@RequestParam String musicName) {	
		return ResponseEntity.ok(this.musicService.getByMusicNameContains(musicName));
	}

	@GetMapping("/getByMusicAndLanguage")
	public ResponseEntity<List<Music_LanguageDto>> getByMusicAndLanguage() {
		return ResponseEntity.ok(this.musicService.getByMusicAndLanguage());
	}
	
	@GetMapping("/getByMusicAndSinger")
	public ResponseEntity<List<Music_SingerDto>> getByMusicAndSinger(@RequestParam String musicName) {
		return ResponseEntity.ok(this.musicService.getByMusicAndSinger(musicName));
	}
	
	@GetMapping("/getByMusicNameAndSingerName")
	public ResponseEntity<List<Music_SingerDto>> getByMusicNameAndSingerName() {
		return ResponseEntity.ok(this.musicService.getByMusicNameAndSingerName());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Music> update(@PathVariable("id") int id, @RequestBody Music music) {
		return ResponseEntity.ok(this.musicService.update(id, music));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id) {
		musicService.deleteById(id);
		return "Müzik Başarıyla Silinmiştir";
	}
	
}
