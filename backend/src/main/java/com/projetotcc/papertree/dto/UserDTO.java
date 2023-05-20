package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.ContributorType;
import com.projetotcc.papertree.entities.User;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private int register;
	private String course;
	private String password;
	private Date admissionDate;
	private ContributorType contributorType;
	
	private List<PostDTO> savedWorks = new ArrayList<>();
	
	public UserDTO() {
	}
	
	public UserDTO(Long id, String name, String email, String cpf, int register, String course, String password,
				   Date admissionDate, ContributorType contributorType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.register = register;
		this.course = course;
		this.password = password;
		this.admissionDate = admissionDate;
		this.contributorType = contributorType;
	}



	public UserDTO(User entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		register = entity.getRegister();
		course = entity.getCourse();
		password = entity.getPassword();
		admissionDate = entity.getAdmissionDate();
		contributorType = entity.getContributorType();
		savedWorks = entity.getSavedPost().stream().map(PostDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public ContributorType getContributorType() {
		return contributorType;
	}

	public void setContributorType(ContributorType contributorType) {
		this.contributorType = contributorType;
	}
	
}
