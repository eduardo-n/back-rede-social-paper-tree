package com.projetotcc.papertree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotcc.papertree.entities.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
