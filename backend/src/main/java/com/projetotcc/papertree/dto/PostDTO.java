package com.projetotcc.papertree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projetotcc.papertree.entities.Post;
import com.projetotcc.papertree.entities.Work;

public class PostDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private Work work;
	
	private List<LikeDTO> likes = new ArrayList<>();

	private List<SavedWorkDTO> savedWorks = new ArrayList<>();
	
	public PostDTO() {
	}

	public PostDTO(Work work) {
		super();
		this.work = work;
	}

	public PostDTO(Long id, Work work) {
		super();
		this.id = id;
		this.work = work;
	}
	
	public PostDTO(Post entity) {
		super();
		this.id = entity.getId();
		this.work = entity.getWork();
		likes = entity.getLikes().stream().map(LikeDTO::new).collect(Collectors.toList());
		savedWorks = entity.getSavedWorks().stream().map(SavedWorkDTO::new).collect(Collectors.toList());
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

	public List<LikeDTO> getLikes() {
		return likes;
	}

	public List<SavedWorkDTO> getSavedWorks() {
		return savedWorks;
	}
	
}
