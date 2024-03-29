package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.entities.Usuario;

public class TrabalhoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String area;
	private String descricao;
	private int avaliacao;

	private List<UsuarioDTO> contribuidores = new ArrayList<>();

	public TrabalhoDTO() {
	}
	
	public TrabalhoDTO(Long id, String titulo, String area, String descricao, int avaliacao, Postagem postagem) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.area = area;
		this.descricao = descricao;
		this.setAvaliacao(avaliacao);
	}



	public TrabalhoDTO(Trabalho entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		area = entity.getArea();
		descricao = entity.getDescricao();
		contribuidores = entity.getContribuidores().stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
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

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<UsuarioDTO> getContribuidores() {
		return contribuidores;
	}

}
