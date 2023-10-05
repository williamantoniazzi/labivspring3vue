package com.fatec.labivbackend.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fatec.labivbackend.entity.CompromissoEntity;

public interface ICompromissoService {

    public CompromissoEntity novoCompromisso(CompromissoEntity compromisso);

    public List<CompromissoEntity> buscarTodosCompromisso();

    public CompromissoEntity buscarPorId(Long id);
    
//   public List<CompromissoEntity> findByCompromissoContainingAndNotaGreaterThan(String nome, LocalDateTime data_hora);
    
}
