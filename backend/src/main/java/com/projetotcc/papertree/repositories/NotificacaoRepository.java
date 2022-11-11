package com.projetotcc.papertree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.Notificacao;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{

}
