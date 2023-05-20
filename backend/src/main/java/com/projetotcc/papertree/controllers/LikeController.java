package com.projetotcc.papertree.controllers;

import java.net.URI;
import java.util.List;

import com.projetotcc.papertree.entities.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetotcc.papertree.dto.LikeDTO;
import com.projetotcc.papertree.services.LikeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/like")
public class LikeController {
	
	@Autowired
	private LikeService service;
	
	@GetMapping
	public ResponseEntity<List<LikeDTO>> findAll(){
		List<LikeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/insert")
	public ResponseEntity<LikeDTO> insertLike(@RequestBody LikeDTO dto){
		dto = service.insert(dto);
		if(dto == null) {
			return ResponseEntity.badRequest().body(null);
		}
		else{
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deleteLike(@PathVariable Long id){
		Like like = service.getLikeById(id);
		service.delete(like);
	}
}
