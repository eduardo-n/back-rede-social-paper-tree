package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.ComentarioDTO;
import com.projetotcc.papertree.services.ComentarioService;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
	
	@Autowired
	private ComentarioService service;
	
	@GetMapping
	public ResponseEntity<List<ComentarioDTO>> findAll(){
		List<ComentarioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
