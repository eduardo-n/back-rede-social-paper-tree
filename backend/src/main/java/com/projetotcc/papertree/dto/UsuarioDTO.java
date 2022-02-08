package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Usuario;

public class UsuarioDTO implements Serializable{
	
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
	
	//private List<TrabalhoDTO> trabalho = new ArrayList<>();
	
	//private List<TrabalhoDTO> trabalhosSalvos = new ArrayList<>();
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email, String cpf, int matricula, String curso, String senha,
			Date dataIngresso, Boolean professor) {
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
	}
	
	public UsuarioDTO(Usuario entity) {
		super();
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.matricula = entity.getMatricula();
		this.curso = entity.getCurso();
		this.senha = entity.getSenha();
		this.dataIngresso = entity.getDataIngresso();
		this.professor = entity.getProfessor();
		//trabalho = entity.getTrabalho().stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		//trabalhosSalvos = entity.getTrabalhosSalvos().stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
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
	
	
}
