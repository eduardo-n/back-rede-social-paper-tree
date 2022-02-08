package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.services.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalhos")
public class TrabalhoController {
	
	@Autowired
	private TrabalhoService service;
	
	@GetMapping
	public ResponseEntity<List<TrabalhoDTO>> findAll(){
		List<TrabalhoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
