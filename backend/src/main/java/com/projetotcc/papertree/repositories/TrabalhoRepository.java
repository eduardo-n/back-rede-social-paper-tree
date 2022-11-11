package com.projetotcc.papertree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetotcc.papertree.entities.Trabalho;
import com.projetotcc.papertree.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

	@Query("SELECT t FROM Trabalho t order by t.dataCriacao, t.avaliacao desc")
	List<Trabalho> findAllTrabalho();
}
