package com.projetotcc.papertree.dto;

import java.io.Serializable;

import com.projetotcc.papertree.entities.Like;
import com.projetotcc.papertree.entities.Post;
import com.projetotcc.papertree.entities.User;

public class LikeDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private User author;

	private Post post;
	
	public LikeDTO() {
	}

	public LikeDTO(Long id, User author, Post post) {
		super();
		this.id = id;
		this.author = author;
		this.post = post;
	}
	
	public LikeDTO(Like entity) {
		super();
		id = entity.getId();
		author = entity.getAuthor();
		post = entity.getPost();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
