package com.jirac.jirac.service;

import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.repository.AtividadeRepository;

public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public Atividade criar(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }


}
