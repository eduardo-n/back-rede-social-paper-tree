package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.Objects;

public class Trabalho implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String area;
	private String descricao;
	private Usuario[] autores;
	private Usuario orientador;
	
	public Trabalho() {
	}
	
	public Trabalho(Long id, String titulo, String area, String descricao, Usuario[] autores, Usuario orientador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.area = area;
		this.descricao = descricao;
		this.autores = autores;
		this.orientador = orientador;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario[] getAutores() {
		return autores;
	}

	public void setAutores(Usuario[] autores) {
		this.autores = autores;
	}

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
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
		Trabalho other = (Trabalho) obj;
		return Objects.equals(id, other.id);
	}
	
}
