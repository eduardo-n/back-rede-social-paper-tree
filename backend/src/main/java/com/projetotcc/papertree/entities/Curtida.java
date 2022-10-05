package com.projetotcc.papertree.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tb_curtida")
public class Curtida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name ="usuario_fk")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postagem_fk")
	@JsonBackReference
	private Postagem postagem;
	
	public Curtida() {
	}
	
	public Curtida(Long id, Usuario autor, Postagem postagem) {
		super();
		this.id = id;
		this.autor = autor;
		this.postagem = postagem;
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

	public Postagem getPostagem() {
		return postagem;
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
