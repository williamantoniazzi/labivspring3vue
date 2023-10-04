package com.fatec.labivbackend.service;

import java.util.List;

import com.fatec.labivbackend.entity.TrabalhoEntity;

public interface ITrabalhoService {

    public TrabalhoEntity novoTrabalho(TrabalhoEntity trabalho);

    public List<TrabalhoEntity> buscarTodosUsuarios();

    public TrabalhoEntity buscarPorId(Long id);
    
}
