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

import com.MusicProgram.musicProgram.business.abstracts.SingerService;
import com.MusicProgram.musicProgram.entities.concretes.Singer;
import com.MusicProgram.musicProgram.entities.dto.Music_SingerDto;

@RestController
@RequestMapping("/singers/")
public class SingersController {

	@Autowired
	private SingerService singerService;
	
	@GetMapping("getAll")
	public ResponseEntity<List<Singer>> getAll() {
		return ResponseEntity.ok(this.singerService.getAll());
	}
	
	@GetMapping("getAllPageAble")
	public ResponseEntity<List<Singer>> getAllPageAble(@RequestParam int pageNo,@RequestParam int pageSize) {
		return ResponseEntity.ok(this.singerService.getAllPageAble(pageNo, pageSize));
	}
	
	@GetMapping("getBySingerNameContains")
	public ResponseEntity<List<Singer>> getBySingerNameContains(@RequestParam String singerName) {
		return ResponseEntity.ok(this.singerService.getBySingerNameContains(singerName));
	}
	
	@GetMapping("getBySingerNameStartsWith")
	public ResponseEntity<List<Singer>> getBySingerNameStartsWith(@RequestParam String singerName) {
		return ResponseEntity.ok(this.singerService.getBySingerNameStartsWith(singerName));
	}
	
	@GetMapping("getBySingerName")
	public ResponseEntity<List<Singer>> getBySingerName(@RequestParam String singerName) {
		return ResponseEntity.ok(this.singerService.getBySingerName(singerName));
	}
	
	@PostMapping("add")
	public ResponseEntity<Singer> add(@RequestBody Singer singer) {
		return ResponseEntity.ok(this.singerService.add(singer));
	}
	
	@GetMapping("getByMusicAndSinger")
	public ResponseEntity<List<Music_SingerDto>> getByMusicAndSinger(@RequestParam String singerName) {
		return ResponseEntity.ok(this.singerService.getByMusicAndSinger(singerName));
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Singer> update(@PathVariable("id") int id, @RequestBody Singer singer) {
		return ResponseEntity.ok(this.singerService.update(id, singer));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@RequestParam int id) {
		singerService.delete(id);
		return ResponseEntity.ok("Müzik Silindi");
	}
}
