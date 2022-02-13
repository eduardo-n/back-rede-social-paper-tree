package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_postagem")
public class Postagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="trabalho_fk")
	private Trabalho trabalho;
	
	@OneToMany(mappedBy = "postagem")
	private List<Comentario> comentarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "postagem")
	private List<Curtida> curtidas = new ArrayList<>();
	
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public List<Curtida> getCurtidas() {
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
