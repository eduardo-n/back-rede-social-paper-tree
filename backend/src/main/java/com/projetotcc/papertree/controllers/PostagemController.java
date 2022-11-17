package com.projetotcc.papertree.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.services.TrabalhoService;
import com.projetotcc.papertree.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/postsUser/{id}")
	public ResponseEntity<List<PostagemDTO>> findPostByUser(@PathVariable("id") Long id){
		List<PostagemDTO> list = service.findPostByUser(id);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/postagemsalvaporusuario/{id}")
	public ResponseEntity<List<PostagemDTO>> buscarTrabalhoSalvoPorUsuario(@PathVariable("id") Long id){
		List<PostagemDTO> list = service.encontrarPostagemSalvaPorUsuario(id);
		return ResponseEntity.ok().body(list);
	}
	
}
