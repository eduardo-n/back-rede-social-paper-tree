package com.projetotcc.papertree.dto;

import java.io.Serializable;

import com.projetotcc.papertree.entities.Notificacao;
import com.projetotcc.papertree.entities.Usuario;
import com.projetotcc.papertree.entities.UsuarioNotificacao;
import com.projetotcc.papertree.entities.UsuarioNotificacaoId;

public class UsuarioNotificacaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioNotificacaoId id;
	private Usuario usuario;
	private Notificacao notificacao;
	private boolean visualizado;
	
	public UsuarioNotificacaoDTO() {
	}

	public UsuarioNotificacaoDTO(UsuarioNotificacaoId id, Usuario usuario, Notificacao notificacao,
			boolean visualizado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.notificacao = notificacao;
		this.visualizado = visualizado;
	}

	public UsuarioNotificacaoDTO(UsuarioNotificacao entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		notificacao = entity.getNotificacao();
		visualizado = entity.isVisualizado();
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
	
}
