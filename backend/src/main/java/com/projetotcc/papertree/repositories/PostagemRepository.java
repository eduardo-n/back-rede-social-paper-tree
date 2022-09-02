package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    @Query("SELECT p FROM Postagem p")
    List<Postagem> findAllPostagem();

}
