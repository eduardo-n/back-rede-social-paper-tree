package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_trabalho")
public class Trabalho implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String area;
	private String descricao;
	
	@OneToMany(
			mappedBy = "trabalho",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Usuario> autores = new ArrayList<>();
	
	@OneToOne
    @JoinColumn(name ="usuario_orientador_fk")
	private Usuario orientador;
	
	public Trabalho() {
	}
	
	public Trabalho(Long id, String titulo, String area, String descricao, Usuario orientador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.area = area;
		this.descricao = descricao;
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

	public List<Usuario> getAutores() {
		return autores;
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
