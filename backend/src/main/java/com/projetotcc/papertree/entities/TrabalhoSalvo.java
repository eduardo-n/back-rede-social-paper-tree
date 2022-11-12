package com.projetotcc.papertree.entities;

import java.io.Serializable;

public class TrabalhoSalvo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Usuario autor;

    private Postagem postagem;

    public TrabalhoSalvo() {
    }

    public TrabalhoSalvo(Long id, Usuario autor, Postagem postagem) {
        super();
        this.id = id;
        this.autor = autor;
        this.postagem = postagem;
    }

    public TrabalhoSalvo(Curtida entity) {
        super();
        id = entity.getId();
        autor = entity.getAutor();
        postagem = entity.getPostagem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
}
