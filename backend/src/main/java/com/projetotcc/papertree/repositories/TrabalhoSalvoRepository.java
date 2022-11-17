package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.Curtida;
import com.projetotcc.papertree.entities.TrabalhoSalvo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabalhoSalvoRepository extends JpaRepository<TrabalhoSalvo, Long> {

    @Query("SELECT ts FROM TrabalhoSalvo ts where ts.id = ?1")
    TrabalhoSalvo buscarTrabalhoSalvo(Long id);

}
