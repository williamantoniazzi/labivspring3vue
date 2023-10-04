package com.fatec.labivbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fatec.labivbackend.entity.TrabalhoEntity;

@Repository
public interface TrabalhoRepository extends JpaRepository<TrabalhoEntity, Long>{

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %:titulo% AND t.nota >= :notaMinima")
    List<TrabalhoEntity> findBytituloContainingAndNotaGreaterThan(String titulo, Integer notaMinima);
    
}
