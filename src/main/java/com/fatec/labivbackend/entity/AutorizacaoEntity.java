package com.fatec.labivbackend.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_autorizacao")
public class AutorizacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @Column(name = "aut_nome")
    private String nome;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "autorizacoes", fetch = FetchType.LAZY)
    private Set<UsuarioEntity> usuarios;

    public AutorizacaoEntity(String nome) {
        this.nome = nome;
    }

    public AutorizacaoEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

}
