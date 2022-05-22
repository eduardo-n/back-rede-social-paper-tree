package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.CurtidaDTO;
import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.repositories.CurtidaRepository;

@Service
public class CurtidaService {

	@Autowired
	private CurtidaRepository repository;
	
	@Transactional
	public List<CurtidaDTO> findAll(){
		List<Curtida> list = repository.findAll();
		return list.stream().map(x -> new CurtidaDTO(x)).collect(Collectors.toList());
	}
}
