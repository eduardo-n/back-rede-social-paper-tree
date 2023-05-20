package com.projetotcc.papertree.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "UserNotification")
@Table(name = "tb_user_notification")
public class NotificationUser {
	
	@EmbeddedId
	private NotificationUserID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userFk")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("notificationFk")
	private Notification notification;
	
	@Column(name = "visualized")
	private boolean visualized;
	
	public NotificationUser() {}

	public NotificationUser(User user, Notification notification) {
		super();
		this.user = user;
		this.notification = notification;
		this.id = new NotificationUserID(user.getId(), notification.getId());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notification == null) ? 0 : notification.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationUser other = (NotificationUser) obj;
		if (notification == null) {
			if (other.notification != null)
				return false;
		} else if (!notification.equals(other.notification))
			return false;
		if (user == null)
			return other.user == null;
		else
			return user.equals(other.user);
	}

	
}
