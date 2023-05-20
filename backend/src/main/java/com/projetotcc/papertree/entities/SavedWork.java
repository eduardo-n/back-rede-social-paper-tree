package com.projetotcc.papertree.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_savedWork")
public class SavedWork implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name ="user_fk")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_fk")
    @JsonBackReference
    private Post post;

    public SavedWork() {
    }

    public SavedWork(Long id, User author, Post post) {
        super();
        this.id = id;
        this.author = author;
        this.post = post;
    }

    public SavedWork(Like entity) {
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
