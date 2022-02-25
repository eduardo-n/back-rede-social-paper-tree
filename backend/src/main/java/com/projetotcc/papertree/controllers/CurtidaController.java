package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.CurtidaDTO;
import com.projetotcc.papertree.services.CurtidaService;

@RestController
@RequestMapping(value = "/curtidas")
public class CurtidaController {
	
	@Autowired
	private CurtidaService service;
	
	@GetMapping
	public ResponseEntity<List<CurtidaDTO>> findAll(){
		List<CurtidaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
