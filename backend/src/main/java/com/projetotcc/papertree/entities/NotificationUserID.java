package com.projetotcc.papertree.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotificationUserID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_fk")
    private Long userFk;
	
	@Column(name = "notificacao_fk")
    private Long notificationFk;
	
	public NotificationUserID() {}

	public NotificationUserID(Long userFk, Long notificationFk) {
		super();
		this.userFk = userFk;
		this.notificationFk = notificationFk;
	}

	public Long getUserFk() {
		return userFk;
	}

	public Long getNotificationFk() {
		return notificationFk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificationFk == null) ? 0 : notificationFk.hashCode());
		result = prime * result + ((userFk == null) ? 0 : userFk.hashCode());
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
		NotificationUserID other = (NotificationUserID) obj;
		if (notificationFk == null) {
			if (other.notificationFk != null)
				return false;
		} else if (!notificationFk.equals(other.notificationFk))
			return false;
		if (userFk == null)
			return other.userFk == null;
		else
			return userFk.equals(other.userFk);
	}
}
