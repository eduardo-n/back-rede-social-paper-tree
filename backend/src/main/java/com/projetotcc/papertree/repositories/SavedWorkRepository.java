package com.projetotcc.papertree.repositories;

import com.projetotcc.papertree.entities.SavedWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedWorkRepository extends JpaRepository<SavedWork, Long> {

    @Query("SELECT sw FROM SavedWork sw where sw.id = ?1")
    SavedWork getSavedWork(Long id);

}
