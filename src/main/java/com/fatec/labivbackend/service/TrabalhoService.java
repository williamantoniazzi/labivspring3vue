package com.fatec.labivbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.labivbackend.entity.TrabalhoEntity;
import com.fatec.labivbackend.repository.TrabalhoRepository;
import jakarta.transaction.Transactional;

@Service
public class TrabalhoService implements ITrabalhoService {
    
    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public List<TrabalhoEntity> BuscarAll(){
        return trabalhoRepo.findAll();
    }

    public TrabalhoEntity buscarporId(long id){
        Optional<TrabalhoEntity> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()){
            throw new IllegalArgumentException("Trabalho nao encontrada!");
        }
        return trabalhoOp.get();
    }

    public List<TrabalhoEntity> buscarTrabalhoPorPalavraENota(String titulo, Integer notaMinima) {
        return trabalhoRepo.findBytituloContainingAndNotaGreaterThan(titulo, notaMinima);
    }

    @Transactional
    public TrabalhoEntity novoTrabalho(TrabalhoEntity trabalho) {
        if(trabalho == null ||
                trabalho.getTitulo().isEmpty() ||
                trabalho.getTitulo() == null ||
                trabalho.getTitulo().isBlank() || 
                trabalho.getNota() == null ||
                trabalho.getData_entrega() == null ||
                trabalho.getDescricao() == null ||
                trabalho.getDescricao().isBlank() ||
                trabalho.getDescricao().isEmpty() ||
                trabalho.getGrupo().isBlank() ||
                trabalho.getGrupo().isEmpty() ||
                trabalho.getJustificativa().isBlank() ||
                trabalho.getJustificativa().isEmpty()) {
            throw new IllegalArgumentException("Trabalho com atributos inválidos!");
        }

        trabalho = trabalhoRepo.save(trabalho);
        return trabalho;

    }

    @Override
    public List<TrabalhoEntity> buscarTodosUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosUsuarios'");
    }

    @Override
    public TrabalhoEntity buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }
}
