package com.fatec.labivbackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.labivbackend.entity.CompromissoEntity;
import com.fatec.labivbackend.repository.CompromissoRepository;
import jakarta.transaction.Transactional;

@Service
public class CompromissoService implements ICompromissoService {
    
    @Autowired
    private CompromissoRepository compromissoRepo;

    public List<CompromissoEntity> buscarTodosCompromisso() {
        return compromissoRepo.findAll();
    }

    public CompromissoEntity buscarporId(long id){
        Optional<CompromissoEntity> compromissoOp = compromissoRepo.findById(id);
        if(compromissoOp.isEmpty()){
            throw new IllegalArgumentException("Compromisso nao encontrada!");
        }
        return compromissoOp.get();
    }

    // Criar uma busta por nome e data assim como em entity

    @Transactional
    public CompromissoEntity novoCompromisso(CompromissoEntity compromisso) {
        if(compromisso == null ||
                compromisso.getNome().isEmpty() ||
                compromisso.getNome() == null ||
                compromisso.getNome().isBlank() || 
                compromisso.getData_hora() == null ||
                compromisso.getDuracao_prevista() == null) {
            throw new IllegalArgumentException("Compromisso com atributos inválidos!");
        }

        compromisso = compromissoRepo.save(compromisso);
        return compromisso;

    }

 /*   public List<CompromissoEntity> buscarCompromissoPorPalavraENota(String nome, LocalDateTime data_hora) {
        return compromissoRepo.findByCompromissoContainingAndNotaGreaterThan(nome, data_hora);
    } */

    @Override
    public CompromissoEntity buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

}
