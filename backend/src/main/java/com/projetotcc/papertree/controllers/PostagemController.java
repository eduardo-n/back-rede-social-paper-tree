package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.PostagemDTO;
import com.projetotcc.papertree.services.PostagemService;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemController {

	@Autowired
	private PostagemService service;
	
	@GetMapping
	public ResponseEntity<List<PostagemDTO>> findAll(){
		List<PostagemDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
