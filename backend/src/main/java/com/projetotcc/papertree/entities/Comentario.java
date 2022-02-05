package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Usuario autor;
	private Set<Curtida> curtidas = new HashSet<>();
	private String texto;
	
	public Comentario() {
	}

	public Comentario(Long id, Usuario autor, String texto) {
		super();
		this.id = id;
		this.autor = autor;
		this.texto = texto;
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

	public Set<Curtida> getCurtidas() {
		return curtidas;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
