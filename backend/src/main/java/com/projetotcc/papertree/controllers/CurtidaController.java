package com.projetotcc.papertree.controllers;

import java.net.URI;
import java.util.List;

import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetotcc.papertree.dto.CurtidaDTO;
import com.projetotcc.papertree.services.CurtidaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping("/inserir")
	public ResponseEntity<CurtidaDTO> inserirCurtida(@RequestBody CurtidaDTO dto){
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

	@DeleteMapping("/delete")
	public ResponseEntity<CurtidaDTO> deletarCurtida(@RequestBody CurtidaDTO dto){
		Curtida curtida = service.buscarCurtida(dto.getId());
		service.delete(curtida);
		if(dto == null) {
			return ResponseEntity.badRequest().body(null);
		}
		else{
			return ResponseEntity.ok().body(dto);
		}
	}
}
