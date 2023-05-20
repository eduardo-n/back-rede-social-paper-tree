package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p")
    List<Post> findAllPostagem();

    @Query("SELECT p FROM Post p JOIN p.work as t JOIN t.contributors as c where c.id = ?1")
    List<Post> getPostByUserId(Long id);

    @Query("SELECT p FROM Post p JOIN p.savedWorks as sw JOIN sw.author as a where a.id = ?1")
    List<Post> getSavedPostByUserId(Long id);

}
