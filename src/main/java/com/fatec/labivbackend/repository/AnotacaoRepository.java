package com.fatec.labivbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.labivbackend.entity.AnotacaoEntity;

public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long>{
    
}
