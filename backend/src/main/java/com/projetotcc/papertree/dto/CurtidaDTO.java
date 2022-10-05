package com.projetotcc.papertree.dto;

import java.io.Serializable;

import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.entities.Usuario;

public class CurtidaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private Usuario autor;

	private Postagem postagem;
	
	public CurtidaDTO() {
	}

	public CurtidaDTO(Long id, Usuario autor, Postagem postagem) {
		super();
		this.id = id;
		this.autor = autor;
		this.postagem = postagem;
	}
	
	public CurtidaDTO(Curtida entity) {
		super();
		id = entity.getId();
		autor = entity.getAutor();
		postagem = entity.getPostagem();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
}
