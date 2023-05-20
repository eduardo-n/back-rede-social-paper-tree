package com.projetotcc.papertree.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="work_fk")
	private Work work;

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	@OneToMany(
			mappedBy = "post",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private final List<Like> likes = new ArrayList<>();

	@JsonIgnore
	@LazyCollection(LazyCollectionOption.TRUE)
	@JsonManagedReference
	@OneToMany(
			mappedBy = "post",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER
	)
	private final List<SavedWork> savedWorks = new ArrayList<>();
	
	public Post() {
	}
	
	public Post(Work work) {
		this.work = work;
	}
	
	public Post(Long id, Work work) {
		super();
		this.id = id;
		this.work = work;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public List<SavedWork> getSavedWorks() {
		return savedWorks;
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
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
}
