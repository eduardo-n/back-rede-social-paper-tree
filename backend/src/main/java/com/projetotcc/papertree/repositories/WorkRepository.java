package com.projetotcc.papertree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetotcc.papertree.entities.Work;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long>{

	@Query("SELECT w FROM Work w order by w.creationDate, w.rating desc")
	List<Work> getAllWork();
}
