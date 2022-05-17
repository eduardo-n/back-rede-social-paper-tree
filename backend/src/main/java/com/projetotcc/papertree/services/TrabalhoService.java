package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.TrabalhoDTO;
import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.repositories.TrabalhoRepository;

@Service
public class TrabalhoService {

	@Autowired
	private TrabalhoRepository repository;
	
	@Transactional
	public List<TrabalhoDTO> findAll(){
		List<Trabalho> list = repository.findAll();
		return list.stream().map(x -> new TrabalhoDTO(x)).collect(Collectors.toList());
	}
}
