package com.projetotcc.papertree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetotcc.papertree.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u where u.email = ?1 AND u.senha = ?2")
	Usuario findUsersWithEmailAndPassword(String email, String senha);
	
	@Query("SELECT u FROM Usuario u where u.email = ?1")
	Usuario findUsersWithEmail(String email);
	
	@Query("SELECT u FROM Usuario u where UPPER(u.nome) LIKE %?1% OR u.matricula LIKE %?1%")
	List<Usuario> findUsersBySplitNameOrRegister(String str);
	
}