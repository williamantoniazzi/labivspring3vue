package com.fatec.labivbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.labivbackend.entity.TrabalhoEntity;

public interface TrabalhoRepository extends JpaRepository<TrabalhoEntity, Long> {
    
}
