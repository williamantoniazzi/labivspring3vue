package com.fatec.labivbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.labivbackend.entity.AutorizacaoEntity;

public interface AutorizacaoRepository extends JpaRepository<AutorizacaoEntity, Long>{
    
}
