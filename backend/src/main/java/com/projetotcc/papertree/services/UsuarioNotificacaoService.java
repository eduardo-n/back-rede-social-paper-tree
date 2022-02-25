package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.UsuarioNotificacaoDTO;
import com.projetotcc.papertree.entities.UsuarioNotificacao;
import com.projetotcc.papertree.repositories.UsuarioNotificacaoRepository;

@Service
public class UsuarioNotificacaoService {
	
	@Autowired
	private UsuarioNotificacaoRepository repository;
	
	@Transactional
	public List<UsuarioNotificacaoDTO> findAll(){
		List<UsuarioNotificacao> list = repository.findAll();
		return list.stream().map(x -> new UsuarioNotificacaoDTO(x)).collect(Collectors.toList());
	}
}
