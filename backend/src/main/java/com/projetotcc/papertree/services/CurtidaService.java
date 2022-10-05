package com.projetotcc.papertree.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.projetotcc.papertree.dto.UsuarioDTO;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.CurtidaDTO;
import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.repositories.CurtidaRepository;

@Service
public class CurtidaService {

	@Autowired
	private CurtidaRepository repository;

	@Autowired
	private PostagemService postagemService;
	
	@Transactional
	public List<CurtidaDTO> findAll(){
		List<Curtida> list = repository.findAll();
		return list.stream().map(x -> new CurtidaDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public CurtidaDTO insert(CurtidaDTO entity){
		Curtida curtida = new Curtida(null, entity.getAutor(), entity.getPostagem());

		curtida = repository.save(curtida);
		return new CurtidaDTO(curtida);
	}

	@Transactional
	public void delete (Curtida curtida){
		repository.delete(curtida);
	}

	@Transactional
	public Curtida buscarCurtida(Long id){
		return repository.buscarCurtida(id);
	}
}
