package com.jirac.jirac.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.service.AtividadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Atividade create(@Valid @RequestBody Atividade atividade) {
        return atividadeService.salvar(atividade);
    }

    @GetMapping
    public List<Atividade> list() {
        return atividadeService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Atividade> search(@PathVariable Long id) {
        return atividadeService.buscar(id);
    }

    @PutMapping("/{id}")
    public Atividade update(@PathVariable Long id, @Valid @RequestBody Atividade atividade) {
        atividade.setId(id);
        return atividadeService.salvar(atividade);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        atividadeService.apagar(id);
    }

}
