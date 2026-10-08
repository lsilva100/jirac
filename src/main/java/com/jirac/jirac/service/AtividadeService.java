package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.repository.AtividadeRepository;

@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public Atividade salvar(Atividade a) {
        return atividadeRepository.save(a);
    }

    public List<Atividade> listar() {
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> buscar(Long id) {
        return atividadeRepository.findById(id);
    }

    public void apagar(Long id) {
        atividadeRepository.deleteById(id);
    }

}
