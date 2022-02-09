package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.NotificacaoDTO;
import com.projetotcc.papertree.entities.Notificacao;
import com.projetotcc.papertree.repositories.NotificacaoRepository;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository repository;
	
	@Transactional
	public List<NotificacaoDTO> findAll(){
		List<Notificacao> list = repository.findAll();
		return list.stream().map(x -> new NotificacaoDTO(x)).collect(Collectors.toList());
	}
}
