package com.fatec.labivbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.labivbackend.entity.TrabalhoEntity;

@Repository
public interface TrabalhoRepository extends JpaRepository<TrabalhoEntity, Long>{
    
}
