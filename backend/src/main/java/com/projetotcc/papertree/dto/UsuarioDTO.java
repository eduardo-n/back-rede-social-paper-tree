package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.TipoContribuidor;
import com.projetotcc.papertree.entities.Trabalho;
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
	private TipoContribuidor tipoContribuidor;
	
//	private List<Long> trabalhosSalvos;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Long id, String nome, String email, String cpf, int matricula, String curso, String senha,
			Date dataIngresso, TipoContribuidor tipoContribuidor, List<Long> trabalhosSalvos) {
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
//		this.trabalhosSalvos = trabalhosSalvos;
	}



	public UsuarioDTO(Usuario entity) {
		super();
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		cpf = entity.getCpf();
		matricula = entity.getMatricula();
		curso = entity.getCurso();
		senha = entity.getSenha();
		dataIngresso = entity.getDataIngresso();
		tipoContribuidor = entity.getTipoContribuidor();
//		trabalhosSalvos = entity.getTrabalhosSalvos();
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

//	public List<Long> getTrabalhosSalvos() {
//		return trabalhosSalvos;
//	}
}
