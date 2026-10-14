package com.jirac.jirac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jirac.jirac.entity.Projeto;
import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    Optional<Projeto> findByNome(String nome);

}
