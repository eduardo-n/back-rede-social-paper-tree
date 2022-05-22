package com.projetotcc.papertree.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.services.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalhos")
public class TrabalhoController {
	
	@Autowired
	private TrabalhoService service;
	
	@GetMapping
	public ResponseEntity<List<TrabalhoDTO>> findAll(){
		
		/*
		TrabalhoDTO trabalhoDtoTeste = new TrabalhoDTO();
		Usuario usuarioTeste = new Usuario();
		
		usuarioTeste.setCpf("123456");
		usuarioTeste.setNome("Rachel Reis");
		usuarioTeste.setEmail("rachel@ufv.br");
			
		trabalhoDtoTeste.setOrientador(usuarioTeste);
		
		List<TrabalhoDTO> list = new ArrayList();
		list.add(trabalhoDtoTeste);
		list.add(trabalhoDtoTeste);
		list.add(trabalhoDtoTeste);	
		*/
		
		
		List<TrabalhoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
