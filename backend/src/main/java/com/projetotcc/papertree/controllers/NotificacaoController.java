package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.NotificacaoDTO;
import com.projetotcc.papertree.services.NotificacaoService;


@RestController
@RequestMapping(value = "/notificacoes")
public class NotificacaoController {

	@Autowired
	private NotificacaoService service;
	
	@GetMapping
	public ResponseEntity<List<NotificacaoDTO>> findAll(){
		List<NotificacaoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
