package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Post;
import com.projetotcc.papertree.entities.Work;

public class WorkDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String area;
	private String description;
	private int rating;
	private Date creationDate;

	private List<UserDTO> contributors = new ArrayList<>();

	public WorkDTO() {
	}
	
	public WorkDTO(Long id, String title, String area, String description, int rating, Post post, Date creationDate) {
		super();
		this.id = id;
		this.title = title;
		this.area = area;
		this.description = description;
		this.rating = rating;
		this.creationDate = creationDate;
	}



	public WorkDTO(Work entity) {
		id = entity.getId();
		title = entity.getTitle();
		area = entity.getArea();
		description = entity.getDescription();
		rating = entity.getRating();
		creationDate = entity.getCreationDate();
		contributors = entity.getContributors().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public List<UserDTO> getContributors() {
		return contributors;
	}

}
