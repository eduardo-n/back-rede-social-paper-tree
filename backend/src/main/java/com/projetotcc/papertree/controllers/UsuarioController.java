package com.projetotcc.papertree.controllers;

import java.net.URI;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/login/{email}/{senha}")
	public Boolean findUsersWithEmailAndPassword(@PathVariable("email") String email, @PathVariable("senha") String senha){
		
		byte[] emailBytes = Base64.getDecoder().decode(email);
		String emailDecodificado = new String(emailBytes);
		byte[] senhaBytes = Base64.getDecoder().decode(senha);
		String senhaDecodificada = new String(senhaBytes);
		
		return service.findUsersWithEmailAndPassword(emailDecodificado, senhaDecodificada);
	}
	
	@PostMapping("/inserir")
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	 

	 @GetMapping("/send/{email}")
	 public void send(@PathVariable("email") String email) {
		 SimpleMailMessage message = new SimpleMailMessage();
			
		 byte[] emailBytes = Base64.getDecoder().decode(email);
		 String emailDecodificado = new String(emailBytes);
		 
			message.setFrom("vitinhopaivinha@gmail.com");
			message.setTo(emailDecodificado);
			message.setText(UUID.randomUUID().toString().toUpperCase());
			message.setSubject("Confirmação de email");
			
			mailSender.send(message);
	 }
}
