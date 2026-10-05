package com.jirac.jirac.service;

import com.jirac.jirac.repository.ProjetoRepository;

public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

}
