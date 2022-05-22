package com.projetotcc.papertree.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioNotificacaoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "usuario_fk")
    private Long usuarioFk;
	
	@Column(name = "notificacao_fk")
    private Long notificacaoFk;
	
	public UsuarioNotificacaoId() {}

	public UsuarioNotificacaoId(Long usuarioFk, Long notificacaoFk) {
		super();
		this.usuarioFk = usuarioFk;
		this.notificacaoFk = notificacaoFk;
	}

	public Long getUsuarioFk() {
		return usuarioFk;
	}

	public Long getNotificacaoFk() {
		return notificacaoFk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificacaoFk == null) ? 0 : notificacaoFk.hashCode());
		result = prime * result + ((usuarioFk == null) ? 0 : usuarioFk.hashCode());
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
		if (notificacaoFk == null) {
			if (other.notificacaoFk != null)
				return false;
		} else if (!notificacaoFk.equals(other.notificacaoFk))
			return false;
		if (usuarioFk == null) {
			if (other.usuarioFk != null)
				return false;
		} else if (!usuarioFk.equals(other.usuarioFk))
			return false;
		return true;
	}
}
