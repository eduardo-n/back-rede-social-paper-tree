package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private Set<Usuario> usuarios = new HashSet<>();
	
	public Notificacao() {
	}

	public Notificacao(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
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

	public Set<Usuario> getUsuarios() {
		return usuarios;
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
		Notificacao other = (Notificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
