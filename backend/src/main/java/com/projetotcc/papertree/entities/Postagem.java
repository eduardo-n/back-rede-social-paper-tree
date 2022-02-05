package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Postagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Trabalho trabalho;
	private Set<Comentario> comentarios = new HashSet<>();
	private Set<Curtida> curtidas = new HashSet<>();
	
	public Postagem() {
	}
	
	public Postagem(Long id, Trabalho trabalho) {
		super();
		this.id = id;
		this.trabalho = trabalho;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public Set<Curtida> getCurtidas() {
		return curtidas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postagem other = (Postagem) obj;
		return Objects.equals(id, other.id);
	}
	
}
