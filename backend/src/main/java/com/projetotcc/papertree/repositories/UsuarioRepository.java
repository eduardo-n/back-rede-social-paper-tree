package com.projetotcc.papertree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
