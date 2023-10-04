package com.fatec.labivbackend.controller;

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

import com.fatec.labivbackend.entity.TrabalhoEntity;
import com.fatec.labivbackend.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @GetMapping
    public List<TrabalhoEntity> buscarTodos() {
        return service.BuscarAll();
    }

    @GetMapping(value = "/{id}")
    public TrabalhoEntity buscarporId(@PathVariable("id") Long id) {
        return service.buscarporId(id);
    }

    @GetMapping(value = "/title")
    public List<TrabalhoEntity> buscarTrabalhoPorPalavraENota(@RequestParam String titulo, @RequestParam Integer notaMinima) {
        return service.buscarTrabalhoPorPalavraENota(titulo, notaMinima);
        //Consulta url https://8080-larissasouz-springboot3-oxd7zqackb6.ws-us105.gitpod.io/trabalho?titulo=Teste1&notaMinima=5
    }
    
    @PostMapping
    public TrabalhoEntity novoTrabalho(@RequestBody TrabalhoEntity trabalho) {
        return service.novoTrabalho(trabalho);
    }
}
