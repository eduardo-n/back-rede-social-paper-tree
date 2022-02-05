package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.Objects;

public class Curtida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Usuario autor;
	
	public Curtida() {
	}
	
	public Curtida(Long id, Usuario autor) {
		super();
		this.id = id;
		this.autor = autor;
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
		Curtida other = (Curtida) obj;
		return Objects.equals(id, other.id);
	}
	
}
