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

import com.jirac.jirac.dtos.ProjetoCriarDto;
import com.jirac.jirac.dtos.ProjetoMostrarDto;
import com.jirac.jirac.dtos.ProjetoUpdateDTO;
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
    @PostMapping("/criar")
    public ProjetoMostrarDto create(@Valid @RequestBody ProjetoCriarDto projetoCriarDto) {
        return projetoService.salvar(projetoCriarDto);
    }

    @GetMapping
    public List<ProjetoMostrarDto> list() {
        return projetoService.listar();
    }

    @GetMapping("/{id}")
    public ProjetoMostrarDto search(@PathVariable Long id) {
        return projetoService.buscar(id);
    }

    @PatchMapping("/{id}")
    public ProjetoMostrarDto update(@PathVariable Long id, @Valid @RequestBody ProjetoUpdateDTO projetoUpdateDTO) {
        return projetoService.atualizar(id, projetoUpdateDTO);
    }

    // @PutMapping("/{id}")
    // public Projeto update(@PathVariable Long id, @Valid @RequestBody Projeto
    // projeto) {
    // projeto.setId(id);
    // return projetoService.salvar(projeto);
    // }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projetoService.apagar(id);
    }

    @GetMapping("/encontrarNome")
    public Optional<Projeto> encontrarNome(String nome) {
        return projetoService.encontrarNome(nome);
    }

}
