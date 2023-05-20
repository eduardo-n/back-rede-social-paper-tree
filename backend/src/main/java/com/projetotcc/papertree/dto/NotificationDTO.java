package com.projetotcc.papertree.dto;

import com.projetotcc.papertree.entities.Notification;
import com.projetotcc.papertree.entities.NotificationUser;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NotificationDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;

	public NotificationDTO() {
    }

	public NotificationDTO(Long id, String title, Set<NotificationUser> notificationUser) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public NotificationDTO(Notification entity) {
		super();
		id = entity.getId();
		title = entity.getTitle();
		List<NotificationUserDTO> notificationUser = entity.getNotificationUser().stream().map(NotificationUserDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
