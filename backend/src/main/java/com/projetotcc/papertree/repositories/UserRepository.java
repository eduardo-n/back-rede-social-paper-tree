package com.projetotcc.papertree.repositories;

import java.util.List;

import com.projetotcc.papertree.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projetotcc.papertree.entities.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u where u.email = ?1 AND u.password = ?2")
	UserDTO getUsersByEmailAndPassword(String email, String password);
	
	@Query("SELECT u FROM User u where u.email = ?1")
	User getUsersByEmail(String email);
	
	@Query("SELECT u FROM User u where u.contributorType != 1 AND UPPER(u.name) LIKE %?1% OR u.register LIKE %?1%")
	List<User> getUsersBySplitNameOrRegister(String str);

	@Transactional
	@Modifying
	@Query("Update User set password = ?1 where email = ?2")
	void updateUserPasswordByEmail(String newPassword, String email);
	
}