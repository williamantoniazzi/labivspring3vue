package com.fatec.labivbackend.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fatec.labivbackend.entity.CompromissoEntity;

@Repository
public interface CompromissoRepository extends JpaRepository<CompromissoEntity, Long>{
    
/*/consulta busca compromisso por um nome e depois de uma data/hora (Nome e data recebidos como parametros)
    @Query("SELECT t FROM Comrpromisso t WHERE t.nome LIKE %:nome% AND t.data_hora >= :data_hora")
    List<CompromissoEntity> findByCompromissoContainingAndNotaGreaterThan(String nome, LocalDateTime data_hora);
*/
}


    