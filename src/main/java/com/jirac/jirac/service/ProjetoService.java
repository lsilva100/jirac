package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jirac.jirac.entity.Projeto;
import com.jirac.jirac.repository.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Transactional 
    public Projeto salvar(Projeto p) {
        return projetoRepository.save(p);
    }

    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> buscar(Long id) {
        return projetoRepository.findById(id);
    }

    public void apagar(Long id) {
        projetoRepository.deleteById(id);
    }

}
