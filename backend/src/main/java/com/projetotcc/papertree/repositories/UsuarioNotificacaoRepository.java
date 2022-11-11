package com.projetotcc.papertree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.UsuarioNotificacao;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioNotificacaoRepository extends JpaRepository<UsuarioNotificacao, Long> {

}
