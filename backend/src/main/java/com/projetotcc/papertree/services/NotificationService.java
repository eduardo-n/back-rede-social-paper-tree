package com.projetotcc.papertree.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetotcc.papertree.dto.NotificationDTO;
import com.projetotcc.papertree.entities.Notification;
import com.projetotcc.papertree.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Transactional
	public List<NotificationDTO> findAll(){
		List<Notification> list = repository.findAll();
		return list.stream().map(NotificationDTO::new).collect(Collectors.toList());
	}
}
