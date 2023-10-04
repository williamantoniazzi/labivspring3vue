package com.fatec.labivbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatec.labivbackend.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    public Optional<UsuarioEntity> findByNome(String nome);

    @Query("select u from Usuario u where u.nome = ?1")
    public Optional<UsuarioEntity> buscarPeloNome(String nome);

    public List<UsuarioEntity> findByNomeContainsIgnoreCase(String nome);

    @Query("select u from Usuario u where u.nome like %?1%")
    public List<UsuarioEntity> buscarPeloNomeParecido(String nome);

    public Optional<UsuarioEntity> findByNomeAndSenha(String nome, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Optional<UsuarioEntity> buscarPeloNomeESenha(String nome, String senha);

    public List<UsuarioEntity> findByAutorizacoesNome(String nomeAutorizacao);

    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public List<UsuarioEntity> buscarPeloNomeAutorizacao(String nomeAutorizacao);
    
}
