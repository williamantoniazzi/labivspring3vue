package com.fatec.labivbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.labivbackend.entity.UsuarioEntity;
import com.fatec.labivbackend.service.IUsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping
    public List<UsuarioEntity> buscarTodos() {
        return service.buscarTodosUsuarios();
    }

    @PostMapping
    public UsuarioEntity novoUsuario(@RequestBody UsuarioEntity usuario) {
        return service.novoUsuario(usuario);
    }
    
    @GetMapping(value = "/{id}")
    public UsuarioEntity buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }
}
