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

import com.jirac.jirac.entity.Projeto;
import com.jirac.jirac.service.ProjetoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Projeto create(@Valid @RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);
    }

    @GetMapping
    public List<Projeto> list() {
        return projetoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Projeto> search(@PathVariable Long id) {
        return projetoService.buscar(id);
    }

    @PutMapping("/{id}")
    public Projeto update(@PathVariable Long id, @Valid @RequestBody Projeto projeto) {
        projeto.setId(id);
        return projetoService.salvar(projeto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projetoService.apagar(id);
    }

}
