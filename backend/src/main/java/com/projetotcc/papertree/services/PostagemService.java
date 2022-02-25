package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.PostagemDTO;
import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.repositories.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository repository;
	
	@Transactional
	public List<PostagemDTO> findAll(){
		List<Postagem> list = repository.findAll();
		return list.stream().map(x -> new PostagemDTO(x)).collect(Collectors.toList());
	}
}
