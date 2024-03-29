package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional
	public List<UsuarioDTO> findAll(){
		List<Usuario> list = repository.findAll();
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public  List<UsuarioDTO> findUsersBySplitNameOrRegister(String string){
		List<Usuario> list = repository.findUsersBySplitNameOrRegister(string.toUpperCase());
		
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public Usuario findUsersWithEmailAndPassword(String email, String senha){
		Usuario usuario = new Usuario();
		usuario = (Usuario) repository.findUsersWithEmailAndPassword(email, senha);
		
		if(Objects.isNull(usuario)) {
			return null;
		}
		return usuario;
	}
	
	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto){
		
		Usuario usuarioEmail = new Usuario();
		usuarioEmail = repository.findUsersWithEmail(dto.getEmail());
		if(usuarioEmail == null) {
			Usuario usuario = new Usuario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getMatricula(), 
					dto.getCurso(), dto.getSenha(), dto.getDataIngresso(),dto.getTipoContribuidor(), null);
			
			usuario = repository.save(usuario);
			return new UsuarioDTO(usuario);
		}
		else {
			return null;
		}
		
	}
}