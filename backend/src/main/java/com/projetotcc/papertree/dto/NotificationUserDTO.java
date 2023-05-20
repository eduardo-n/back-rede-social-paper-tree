package com.projetotcc.papertree.dto;

import java.io.Serializable;

import com.projetotcc.papertree.entities.Notification;
import com.projetotcc.papertree.entities.User;
import com.projetotcc.papertree.entities.NotificationUser;
import com.projetotcc.papertree.entities.NotificationUserID;

public class NotificationUserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private NotificationUserID id;
	private User user;
	private Notification notification;
	private boolean visualized;
	
	public NotificationUserDTO() {
	}

	public NotificationUserDTO(NotificationUserID id, User user, Notification notification,
							   boolean visualized) {
		super();
		this.id = id;
		this.user = user;
		this.notification = notification;
		this.visualized = visualized;
	}

	public NotificationUserDTO(NotificationUser entity) {
		id = entity.getId();
		user = entity.getUser();
		notification = entity.getNotification();
		visualized = entity.isVisualized();
	}

	public NotificationUserID getId() {
		return id;
	}

	public void setId(NotificationUserID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public boolean isVisualized() {
		return visualized;
	}

	public void setVisualized(boolean visualized) {
		this.visualized = visualized;
	}
	
}
