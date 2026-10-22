package com.jirac.jirac.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jirac.jirac.dtos.AtividadeCreateRequestDTO;
import com.jirac.jirac.dtos.AtividadeUpdateDTO;
import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.service.AtividadeService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Atividade create(@Valid @RequestBody AtividadeCreateRequestDTO atividadeDTO) {
        return atividadeService.salvar(atividadeDTO);
    }

    @GetMapping
    public List<Atividade> list() {
        return atividadeService.listar();
    }

    @GetMapping("/emAtraso")
    public Optional<List<Atividade>> listarEmAtraso() {
        return atividadeService.listarEmAtraso();
    }
    

    @GetMapping("/{id}")
    public Optional<Atividade> search(@PathVariable Long id) {
        return atividadeService.buscar(id);
    }

    @PatchMapping("/{id}")
    public Atividade update(@PathVariable Long id, @Valid @RequestBody AtividadeUpdateDTO atividadeUpdateDTO) {
        return atividadeService.atualizar(id, atividadeUpdateDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        atividadeService.apagar(id);
    }

}
