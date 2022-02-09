package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Comentario;
import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.entities.Postagem;
import com.projetotcc.papertree.entities.Trabalho;

public class PostagemDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	private Trabalho trabalho;
	
	private List<Comentario> comentarios = new ArrayList<>();
	
	private List<Curtida> curtidas = new ArrayList<>();
	
	public PostagemDTO() {
	}

	public PostagemDTO(Trabalho trabalho) {
		super();
		this.trabalho = trabalho;
	}
	
	public PostagemDTO(Postagem entity) {
		super();
		this.trabalho = entity.getTrabalho();
		//comentarios = entity.getComentarios().stream().map(x -> new ComentarioDTO(x)).collect(Collectors.toList());
		//curtidas = entity.getCurtidas().stream().map(x -> new CurtidaDTO(x)).collect(Collectors.toList());
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
	
}
