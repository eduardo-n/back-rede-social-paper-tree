package com.projetotcc.papertree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotcc.papertree.dto.NotificationDTO;
import com.projetotcc.papertree.services.NotificationService;


@RestController
@RequestMapping(value = "/notification")
public class NotificationController {
	@Autowired
	private NotificationService service;
	
	@GetMapping
	public ResponseEntity<List<NotificationDTO>> findAll(){
		List<NotificationDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
