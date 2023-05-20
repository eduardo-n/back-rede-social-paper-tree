package com.projetotcc.papertree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.NotificationUser;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationUserRepository extends JpaRepository<NotificationUser, Long> {

}
