package com.projetotcc.papertree.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioNotificacaoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "usuario_id")
    private Long usuarioId;
	
	@Column(name = "notificacao_id")
    private Long notificacaoId;
	
	public UsuarioNotificacaoId() {}

	public UsuarioNotificacaoId(Long usuarioId, Long notificacaoId) {
		super();
		this.usuarioId = usuarioId;
		this.notificacaoId = notificacaoId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public Long getNotificacaoId() {
		return notificacaoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificacaoId == null) ? 0 : notificacaoId.hashCode());
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
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
		UsuarioNotificacaoId other = (UsuarioNotificacaoId) obj;
		if (notificacaoId == null) {
			if (other.notificacaoId != null)
				return false;
		} else if (!notificacaoId.equals(other.notificacaoId))
			return false;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}
}
