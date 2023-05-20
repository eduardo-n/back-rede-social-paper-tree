package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
    @Query("SELECT c FROM Like c where c.id = ?1")
    Like getLikeById(Long id);
}
