package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3labiv.entity.Autorizacao;
import br.gov.sp.fatec.springboot3labiv.entity.Trabalho;
import br.gov.sp.fatec.springboot3labiv.repository.TrabalhoRepository;
import jakarta.transaction.Transactional;

@Service
public class TrabalhoService {
    
    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public List<Trabalho> BuscarAll(){
        return trabalhoRepo.findAll();
    }

    public Trabalho buscarporId(long id){
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()){
            throw new IllegalArgumentException("Autorizacao nao encontrada!");
        }
        return trabalhoOp.get();
    }

    public List<Trabalho> buscarTrabalhoPorPalavraENota(String titulo, Integer notaMinima) {
        return trabalhoRepo.findBytituloContainingAndNotaGreaterThan(titulo, notaMinima);
    }

    @Transactional
    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho == null ||
                trabalho.getTitulo().isEmpty() ||
                trabalho.getTitulo() == null ||
                trabalho.getTitulo().isBlank() || 
                trabalho.getNota() == null ||
                trabalho.getDataHora() == null ||
                trabalho.getDescricao() == null ||
                trabalho.getDescricao().isBlank() ||
                trabalho.getDescricao().isEmpty() ||
                trabalho.getGrupo().isBlank() ||
                trabalho.getGrupo().isEmpty() ||
                trabalho.getJustificativa().isBlank() ||
                trabalho.getJustificativa().isEmpty()) {
            throw new IllegalArgumentException("Usuário com atributos inválidos!");
        }

        trabalho = trabalhoRepo.save(trabalho);
        return trabalho;

    }
}
