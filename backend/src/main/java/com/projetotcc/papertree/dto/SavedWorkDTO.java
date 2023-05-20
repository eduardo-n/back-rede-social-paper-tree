package com.projetotcc.papertree.dto;

import com.projetotcc.papertree.entities.Post;
import com.projetotcc.papertree.entities.SavedWork;
import com.projetotcc.papertree.entities.User;

import java.io.Serializable;

public class SavedWorkDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private User author;

    private Post post;

    public SavedWorkDTO() {
    }

    public SavedWorkDTO(Long id, User author, Post post) {
        super();
        this.id = id;
        this.author = author;
        this.post = post;
    }

    public SavedWorkDTO(SavedWork entity) {
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
