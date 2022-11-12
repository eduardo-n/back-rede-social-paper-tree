package com.projetotcc.papertree.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

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

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference
	@OneToMany(
			mappedBy = "postagem",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Curtida> curtidas = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference
	@OneToMany(
			mappedBy = "postagem",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<TrabalhoSalvo> trabalhosSalvos = new ArrayList<>();
	
	public Postagem() {
	}
	
	public Postagem(Trabalho trabalho) {
		this.trabalho = trabalho;
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

	public List<Curtida> getCurtidas() {
		return curtidas;
	}

	public List<TrabalhoSalvo> getTrabalhosSalvos() {
		return trabalhosSalvos;
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
