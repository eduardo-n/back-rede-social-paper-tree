package com.projetotcc.papertree.controllers;

import java.net.URI;
import java.util.List;

import com.projetotcc.papertree.entities.ContributorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetotcc.papertree.dto.UserDTO;
import com.projetotcc.papertree.entities.User;
import com.projetotcc.papertree.services.SendEmailService;
import com.projetotcc.papertree.services.UserService;
import com.projetotcc.papertree.util.Util;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
    private SendEmailService sendEmailService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/search/{str}")
	public ResponseEntity<List<UserDTO>> getUsersBySplitNameOrRegister(@PathVariable("str") String str){
		List<UserDTO> list = service.getUsersBySplitNameOrRegister(str);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Object> findUsersWithEmailAndPassword(@RequestParam (name = "email", required = true) String email, @RequestParam (name = "password", required = true) String password){
		
//		String decodedEmail = Util.decodeValue(email);
//
//		String decodedPassword = Util.decodeValue(password);
		
		UserDTO user = service.getUsersByEmailAndPassword(email, password);
		if(user == null) {
			return ResponseEntity.badRequest().body("1");
		}
		else{
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody UserDTO dto,
										  @RequestParam (name = "token", required = false) String token){
		
//		String decodedEmail = Util.decodeValue(dto.getEmail());
//		String decodedPassword = Util.decodeValue(dto.getSenha());
		
//		dto.setEmail(decodedEmail);
//		dto.setSenha(decodedPassword);

		if(isAdvisor(dto)){
			//String decodedToken = Util.decodeValue(token);
			if(!validateTokenAdvisor(token)) return ResponseEntity.badRequest().body("Token orientador inválido!");
		}

		dto = service.insert(dto);
		if(dto == null) {
			return ResponseEntity.badRequest().body("Já existe um usuário com esse email cadastrado!");
		}
		else{
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		}
		
	}

	@PutMapping("/update/password")
	public ResponseEntity<Object> updatePassword(@RequestParam (name = "email", required = true) String email, @RequestParam (name = "password", required = true) String password){

//		String decodedEmail = Util.decodeValue(email);
//		String decodedPassword = Util.decodeValue(password);

//		dto.setEmail(decodedEmail);
//		dto.setSenha(decodedPassword);

		Boolean status = service.updatePassword(email, password);
		if(!status) {
			return ResponseEntity.badRequest().body("Erro ao atualizar senha!");
		}
		else{
			return ResponseEntity.ok().body("Sucesso");
		}

	}
	
	@PostMapping("/token/email")
    public ResponseEntity<Object> sendMail(@RequestBody String email) {
		//String decodedEmail = Util.decodeValue(email);
		String token = sendEmailService.sendEmail(email);
		if(token != null)
			return ResponseEntity.ok().body(token);
		else
			return ResponseEntity.badRequest().body("Erro ao enviar email!");
    }

	public boolean isAdvisor(UserDTO user){
		return user.getContributorType() == ContributorType.ADVISOR;
	}

    public Boolean validateTokenAdvisor(String decodedToken){
		//this Token is hard code because it will be provided exclusively for advisors
        if(decodedToken.equals("FFA74UFV1355U8ABU981"))
            return true;
        return false;
    }
}