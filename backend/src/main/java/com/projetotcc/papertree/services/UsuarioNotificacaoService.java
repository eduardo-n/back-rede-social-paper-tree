package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.NotificationUserDTO;
import com.projetotcc.papertree.entities.NotificationUser;
import com.projetotcc.papertree.repositories.NotificationUserRepository;

@Service
public class UsuarioNotificacaoService {
	
	@Autowired
	private NotificationUserRepository repository;
	
	@Transactional
	public List<NotificationUserDTO> findAll(){
		List<NotificationUser> list = repository.findAll();
		return list.stream().map(NotificationUserDTO::new).collect(Collectors.toList());
	}
}
