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

@Entity(name = "User")
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String cpf;
	private int register;
	private String course;
	private String password;
	private Date admissionDate;
	private ContributorType contributorType;

	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
    @JoinTable(name = "tb_user_saved_post",
        joinColumns = @JoinColumn(name = "user_fk"),
        inverseJoinColumns = @JoinColumn(name = "saved_post_fk"))
	private List<Post> listSavedPost = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(
	        mappedBy = "user",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
    private List<NotificationUser> notificationUser = new ArrayList<NotificationUser>();
	
	public User() {
	}

	public User(Long id, String name, String email, String cpf, int register, String course, String password,
				Date admissionDate, ContributorType contributorType,
				List<NotificationUser> notificationUser) {
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
		this.notificationUser = notificationUser;
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
	
	public List<Post> getSavedPost() {
		return listSavedPost;
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
		User other = (User) obj;
		if (id == null)
			return other.id == null;
		else
			return id.equals(other.id);
	}
}
