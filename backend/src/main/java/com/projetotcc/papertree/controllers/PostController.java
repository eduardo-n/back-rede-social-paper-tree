package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.PostDTO;
import com.projetotcc.papertree.services.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll(){
		List<PostDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/user/id/{id}")
	public ResponseEntity<List<PostDTO>> findPostByUser(@PathVariable("id") Long id){
		List<PostDTO> list = service.findPostByUserId(id);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/saved/user/id/{id}")
	public ResponseEntity<List<PostDTO>> getSavedPostByUserId(@PathVariable("id") Long id){
		List<PostDTO> list = service.getSavedPostByUserId(id);
		return ResponseEntity.ok().body(list);
	}
	
}
