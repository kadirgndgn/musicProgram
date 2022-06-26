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

import com.MusicProgram.musicProgram.business.abstracts.AlbumsService;
import com.MusicProgram.musicProgram.entities.concretes.Albums;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

	private AlbumsService albumsService;

	@Autowired
	public AlbumsController(AlbumsService albumsService) {
		super();
		this.albumsService = albumsService;
	}
	
	@GetMapping("/getByAlbumNameContains")
	public ResponseEntity<List<Albums>> getByAlbumNameContains(@RequestParam String albumName) {
		return ResponseEntity.ok(this.albumsService.getByAlbumNameContains(albumName));
	}
	
	@GetMapping("/getByAlbumName")
	public ResponseEntity<List<Albums>> getByAlbumName(@RequestParam String albumName) {
		return ResponseEntity.ok(this.albumsService.getByAlbumName(albumName));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Albums>> getAll() {
		return ResponseEntity.ok(this.albumsService.getAll());
	}
	
	@GetMapping("/getAllPageAble")
	public ResponseEntity<List<Albums>> getAllPageAble(@RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.albumsService.getAllPageAble(pageNo, pageSize));
	}

	@PostMapping("/add")
	public ResponseEntity<Albums> add(@RequestBody Albums albums) {
		return ResponseEntity.ok(this.albumsService.add(albums));
	}
	
    @PutMapping("update/{id}")
	public ResponseEntity<Albums> update(@PathVariable("id") int id, @RequestBody Albums albums) {
		return ResponseEntity.ok(this.albumsService.update(id, albums));
	}
	
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
    	albumsService.delete(id);
    	return ResponseEntity.ok().build();
    }
	
}