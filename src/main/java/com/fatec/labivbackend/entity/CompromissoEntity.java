package com.fatec.labivbackend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cpm_compromisso")
public class CompromissoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cpm_id")
    private Long id;
    
    @Column (name = "cpm_nome")
    private String nome;
    
    @Column (name = "cpm_data_hora")
    private LocalDateTime data_hora;

    @Column (name = "cpm_duracao_prevista")
    private Float duracao_prevista;

    @Column (name = "cpm_cep")
    private Long cep;

    @Column (name = "cpm_numero")
    private Integer numero;



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

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_entrega(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public Float getDuracao_prevista() {
        return duracao_prevista;
    }

    public void setDuracao_prevista(Float duracao_prevista) {
        this.duracao_prevista = duracao_prevista;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}