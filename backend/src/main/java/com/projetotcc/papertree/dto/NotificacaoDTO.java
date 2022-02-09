package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Notificacao;
import com.projetotcc.papertree.entities.UsuarioNotificacao;

public class NotificacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;

   private List<UsuarioNotificacaoDTO> usuarioNotificacao = new ArrayList<>();
    
    public NotificacaoDTO() {
    }

	public NotificacaoDTO(Long id, String titulo, Set<UsuarioNotificacao> usuarioNotificacao) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	
	public NotificacaoDTO(Notificacao entity) {
		super();
		id = entity.getId();
		titulo = entity.getTitulo();
		usuarioNotificacao = entity.getUsuarioNotificacao().stream().map(x -> new UsuarioNotificacaoDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    
}
