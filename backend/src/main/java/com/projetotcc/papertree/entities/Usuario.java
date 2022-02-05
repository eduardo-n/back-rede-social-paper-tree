package com.projetotcc.papertree.entities;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private int matricula;
	private String curso;
	private String senha;
	private Date dataIngresso;
	private Boolean professor;
	private Trabalho[] trabalhosSalvos;
	private Notificacao[] notificacoes;
	
	public Usuario() {		
	}

	public Usuario(Long id, String nome, String email, String cpf, int matricula, String curso, String senha,
			Date dataIngresso, Boolean professor, Trabalho[] trabalhosSalvos, Notificacao[] notificacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.matricula = matricula;
		this.curso = curso;
		this.senha = senha;
		this.dataIngresso = dataIngresso;
		this.professor = professor;
		this.trabalhosSalvos = trabalhosSalvos;
		this.notificacoes = notificacoes;
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

	public Boolean getProfessor() {
		return professor;
	}

	public void setProfessor(Boolean professor) {
		this.professor = professor;
	}

	public Trabalho[] getTrabalhosSalvos() {
		return trabalhosSalvos;
	}

	public void setTrabalhosSalvos(Trabalho[] trabalhosSalvos) {
		this.trabalhosSalvos = trabalhosSalvos;
	}

	public Notificacao[] getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(Notificacao[] notificacoes) {
		this.notificacoes = notificacoes;
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
