package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.Objects;

public class Postagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Trabalho trabalho;
	private Comentario[] comentarios;
	private Curtida[] curtida;
	
	public Postagem() {
	}
	
	public Postagem(Long id, Trabalho trabalho, Comentario[] comentarios, Curtida[] curtida) {
		super();
		this.id = id;
		this.trabalho = trabalho;
		this.comentarios = comentarios;
		this.curtida = curtida;
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

	public Comentario[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}

	public Curtida[] getCurtida() {
		return curtida;
	}

	public void setCurtida(Curtida[] curtida) {
		this.curtida = curtida;
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
