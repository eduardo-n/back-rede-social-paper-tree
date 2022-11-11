package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    @Query("SELECT p FROM Postagem p")
    List<Postagem> findAllPostagem();

    @Query("SELECT p FROM Postagem p JOIN p.trabalho as t JOIN t.contribuidores as c where c.id = ?1")
    List<Postagem> findPostByUser(Long id);

}
