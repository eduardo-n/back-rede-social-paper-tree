package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.entities.Trabalho;

public class PostagemDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private Trabalho trabalho;
	
	private List<CurtidaDTO> curtidas = new ArrayList<>();

	private List<TrabalhoSalvoDTO> trabalhosSalvos = new ArrayList<>();
	
	public PostagemDTO() {
	}

	public PostagemDTO(Trabalho trabalho) {
		super();
		this.trabalho = trabalho;
	}

	public PostagemDTO(Long id, Trabalho trabalho) {
		super();
		this.id = id;
		this.trabalho = trabalho;
	}
	
	public PostagemDTO(Postagem entity) {
		super();
		this.id = entity.getId();
		this.trabalho = entity.getTrabalho();
		curtidas = entity.getCurtidas().stream().map(CurtidaDTO::new).collect(Collectors.toList());
		trabalhosSalvos = entity.getTrabalhosSalvos().stream().map(TrabalhoSalvoDTO::new).collect(Collectors.toList());
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

	public List<CurtidaDTO> getCurtidas() {
		return curtidas;
	}

	public List<TrabalhoSalvoDTO> getTrabalhosSalvos() {
		return trabalhosSalvos;
	}
	
}
