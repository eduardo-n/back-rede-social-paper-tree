package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.ComentarioDTO;
import com.projetotcc.papertree.entities.Comentario;
import com.projetotcc.papertree.repositories.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository repository;
	
	@Transactional
	public List<ComentarioDTO> findAll(){
		List<Comentario> list = repository.findAll();
		return list.stream().map(x -> new ComentarioDTO(x)).collect(Collectors.toList());
	}
}
