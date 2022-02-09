package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Comentario;
import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.entities.Usuario;

public class ComentarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String texto;
	private Usuario autor;
	private Postagem postagem;
	
	private List<CurtidaDTO> curtidas = new ArrayList<>();
	
	public ComentarioDTO() {
	}

	public ComentarioDTO(Long id, String texto, Usuario autor, Postagem postagem) {
		super();
		this.id = id;
		this.texto = texto;
		this.autor = autor;
		this.postagem = postagem;
	}
	
	public ComentarioDTO(Comentario entity) {
		id = entity.getId();
		texto = entity.getTexto();
		autor = entity.getAutor();
		postagem = entity.getPostagem();
		curtidas = entity.getCurtidas().stream().map(x -> new CurtidaDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
