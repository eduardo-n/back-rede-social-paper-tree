package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.Curtida;
import org.springframework.data.jpa.repository.Query;

public interface CurtidaRepository extends JpaRepository<Curtida, Long>{
    @Query("SELECT c FROM Curtida c where c.id = ?1")
    Curtida buscarCurtida(Long id);
}
