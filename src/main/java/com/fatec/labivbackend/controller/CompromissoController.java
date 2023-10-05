package com.fatec.labivbackend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.labivbackend.entity.CompromissoEntity;
import com.fatec.labivbackend.service.CompromissoService;

@RestController
@RequestMapping(value = "/compromisso")
@CrossOrigin
public class CompromissoController {

    @Autowired
    private CompromissoService service;

    @GetMapping
    public List<CompromissoEntity> buscarTodosCompromisso() {
        return service.buscarTodosCompromisso();
    }

    @GetMapping(value = "/{id}")
    public CompromissoEntity buscarporId(@PathVariable("id") Long id) {
        return service.buscarporId(id);
    }

    @PostMapping
    public CompromissoEntity novoCompromisso(@RequestBody CompromissoEntity compromisso) {
        return service.novoCompromisso(compromisso);
    }

 /*   @GetMapping(value = "/compromissobusca")
    public List<CompromissoEntity> buscarCompromissoPorPalavraENota(@RequestParam String nome, @RequestParam LocalDateTime data_hora) {
        return service.buscarCompromissoPorPalavraENota(nome, data_hora);
        
        //Consulta url https://8080-larissasouz-springboot3-oxd7zqackb6.ws-us105.gitpod.io/trabalho?titulo=Teste1&notaMinima=5
    } */
}
