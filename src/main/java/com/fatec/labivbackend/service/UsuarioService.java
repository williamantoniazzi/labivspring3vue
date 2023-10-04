package com.fatec.labivbackend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.labivbackend.entity.AnotacaoEntity;
import com.fatec.labivbackend.entity.AutorizacaoEntity;
import com.fatec.labivbackend.entity.UsuarioEntity;
import com.fatec.labivbackend.repository.AnotacaoRepository;
import com.fatec.labivbackend.repository.AutorizacaoRepository;
import com.fatec.labivbackend.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Autowired
    private AnotacaoRepository anotacaoRepo;

    @Transactional
    public UsuarioEntity novoUsuario(UsuarioEntity usuario) {
        if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() || 
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Usuário com atributos inválidos!");
        }
        if(!usuario.getAutorizacoes().isEmpty()) {
            Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
            for(Autorizacao autorizacao: usuario.getAutorizacoes()) {
                Autorizacao autorizacaoBd = buscarAutorizacaoPorId(autorizacao.getId());
                autorizacoes.add(autorizacaoBd);
            }
            usuario.setAutorizacoes(autorizacoes);
        }
        Set<Anotacao> anotacoes = usuario.getAnotacoes();
        usuario.setAnotacoes(new HashSet<Anotacao>());
        usuario = usuarioRepo.save(usuario);
        for(Anotacao anotacao: anotacoes) {
            anotacao.setUsuario(usuario);
            anotacao = anotacaoRepo.save(anotacao);
            usuario.getAnotacoes().add(anotacao);
        }
        
        return usuario;
    }

    public List<UsuarioEntity> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    public UsuarioEntity buscarPorId(Long id) {
        Optional<UsuarioEntity> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new IllegalArgumentException("Usuario nao encontrado!");
        }
        return usuarioOp.get();
    }

    public Autorizacao buscarAutorizacaoPorId(Long id) {
        Optional<Autorizacao> autorizacaoOp = autorizacaoRepo.findById(id);
        if(autorizacaoOp.isEmpty()) {
            throw new IllegalArgumentException("Autorizacao nao encontrada!");
        }
        return autorizacaoOp.get();
    }


}
