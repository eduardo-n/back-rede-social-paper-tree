package com.projetotcc.papertree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
