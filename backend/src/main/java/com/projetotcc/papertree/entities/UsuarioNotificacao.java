package com.projetotcc.papertree.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "UsuarioNotificacao")
@Table(name = "tb_usuario_notificacao")
public class UsuarioNotificacao {
	
	@EmbeddedId
	private UsuarioNotificacaoId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("usuarioId")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("notificacaoId")
	private Notificacao notificacao;
	
	@Column(name = "visualizado")
	private boolean visualizado;
	
	public UsuarioNotificacao() {}

	public UsuarioNotificacao(Usuario usuario, Notificacao notificacao) {
		super();
		this.usuario = usuario;
		this.notificacao = notificacao;
		this.id = new UsuarioNotificacaoId(usuario.getId(), notificacao.getId());
	}

	public UsuarioNotificacaoId getId() {
		return id;
	}

	public void setId(UsuarioNotificacaoId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public boolean isVisualizado() {
		return visualizado;
	}

	public void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificacao == null) ? 0 : notificacao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		UsuarioNotificacao other = (UsuarioNotificacao) obj;
		if (notificacao == null) {
			if (other.notificacao != null)
				return false;
		} else if (!notificacao.equals(other.notificacao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
}
