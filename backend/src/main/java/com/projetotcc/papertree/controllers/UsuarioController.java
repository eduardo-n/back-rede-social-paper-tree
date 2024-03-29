package com.projetotcc.papertree.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.services.SendEmailService;
import com.projetotcc.papertree.services.UsuarioService;
import com.projetotcc.papertree.util.Util;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
    private SendEmailService sendEmailService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/search/{str}")
	public ResponseEntity<List<UsuarioDTO>> findUsersBySplitNameOrRegister(@PathVariable("str") String str){
		List<UsuarioDTO> list = service.findUsersBySplitNameOrRegister(str);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/login/{email}/{senha}")
	public Usuario findUsersWithEmailAndPassword(@PathVariable("email") String email, @PathVariable("senha") String senha){
		
		String emailDecodificado = Util.decodeValue(email);
		
		String senhaDecodificada = Util.decodeValue(senha);
		
		return service.findUsersWithEmailAndPassword(emailDecodificado, senhaDecodificada);
	}
	
	@PostMapping("/inserir")
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto){
		
//		String emailDecodificado = Util.decodeValue(dto.getEmail());		
//		String senhaDecodificada = Util.decodeValue(dto.getSenha());
		
//		dto.setEmail(emailDecodificado);
//		dto.setSenha(senhaDecodificada);
		
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
	
	@PostMapping("/email/{email}")
    public int sendMail(@PathVariable("email") String email) {
		String emailDecodificado = Util.decodeValue(email);
		int token = sendEmailService.sendEmail(emailDecodificado);
		if(token != 0) 
			return token; 
		else return 0;
    }
	
	@GetMapping("/validar/{token}/orientador")
    public Boolean validTokenProfessorOrientador(@PathVariable("token") String token){

		String tokenDecodificado = Util.decodeValue(token);

        if(tokenDecodificado.equals("FFA74UFV1355U8ABU981"))
            return true;
        return false;
    }
}