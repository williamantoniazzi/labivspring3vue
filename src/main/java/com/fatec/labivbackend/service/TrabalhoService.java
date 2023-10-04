package com.fatec.labivbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.labivbackend.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public Trabalho buscarTrabalhoPorId(Long id) {
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()) {
            throw new IllegalArgumentException("Trabalho nao encontrado!");
        }
        return trabalhoOp.get();
    }

    public Trabalho novoTrabalho(Trabalho trabalho) { if(usuario == null ||
    usuario.getNome() == null || usuario.getSenha() == null) {
    throw new IllegalArgumentException("Nome e senha inválidos!");
    }
    return usuarioRepo.save(usuario);
    }

    public List<Trabalho> buscarTodos() { 
        return trabalhoRepo.findAll();
    }

    
    
}
