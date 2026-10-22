package com.jirac.jirac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.entity.Projeto;
import com.jirac.jirac.enums.StatusProjeto;

import java.util.List;
import java.util.Optional;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    Optional<Atividade> findByProjeto(Projeto projeto);

    @Query(value = "SELECT * FROM atividade WHERE status = 4 ", nativeQuery = true)
    Optional<List<Atividade>> findAtrasado();

    @Query(value = "SELECT * FROM atividade WHERE status = 3 ", nativeQuery = true)
    Optional<Atividade> findFinalizado(StatusProjeto statusProjeto);
}
