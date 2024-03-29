package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String cpf;
	private int matricula;
	private String curso;
	private String senha;
	private Date dataIngresso;
	private TipoContribuidor tipoContribuidor;

	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
    @JoinTable(name = "tb_usuario_postagem_salva",
        joinColumns = @JoinColumn(name = "usuario_fk"),
        inverseJoinColumns = @JoinColumn(name = "postagem_salva_fk"))
	private List<Postagem> postagensSalvas = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(
	        mappedBy = "usuario",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
    private List<UsuarioNotificacao> usuarioNotificacao = new ArrayList<UsuarioNotificacao>();
	
	public Usuario() {		
	}

	public Usuario(Long id, String nome, String email, String cpf, int matricula, String curso, String senha,
			Date dataIngresso, TipoContribuidor tipoContribuidor,
			List<UsuarioNotificacao> usuarioNotificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.matricula = matricula;
		this.curso = curso;
		this.senha = senha;
		this.dataIngresso = dataIngresso;
		this.tipoContribuidor = tipoContribuidor;
		this.usuarioNotificacao = usuarioNotificacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public TipoContribuidor getTipoContribuidor() {
		return tipoContribuidor;
	}

	public void setTipoContribuidor(TipoContribuidor tipoContribuidor) {
		this.tipoContribuidor = tipoContribuidor;
	}
	
	public List<Postagem> getPostagensSalvas() {
		return postagensSalvas;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
