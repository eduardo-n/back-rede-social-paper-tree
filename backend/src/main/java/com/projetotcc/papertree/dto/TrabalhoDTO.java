package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.entities.Usuario;

public class TrabalhoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String area;
	private String descricao;

	private List<UsuarioDTO> autores = new ArrayList<>();
	
	private Usuario orientador;

	public TrabalhoDTO() {
	}
	
	public TrabalhoDTO(String titulo, String area, String descricao, Usuario orientador) {
		super();
		this.titulo = titulo;
		this.area = area;
		this.descricao = descricao;
		this.orientador = orientador;
	}
	
	public TrabalhoDTO(Trabalho entity) {
		titulo = entity.getTitulo();
		area = entity.getArea();
		descricao = entity.getDescricao();
		orientador = entity.getOrientador();
		autores = entity.getAutores().stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
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

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}
	
}
