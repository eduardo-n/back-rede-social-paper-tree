package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/login/{email}/{senha}")
	public Boolean findUsersWithEmailAndPassword(@PathVariable("email") String email, @PathVariable("senha") String senha){
		return service.findUsersWithEmailAndPassword(email, senha);
	}
}
