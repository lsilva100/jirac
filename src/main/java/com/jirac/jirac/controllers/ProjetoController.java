package com.jirac.jirac.controllers;

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

    public ProjetoController(ProjetoService projetoService){
        this.projetoService = projetoService;
    }

    @ResponseStatus(HttpStatus.CREATED) 
    @PostMapping
    public void create(@Valid @RequestBody Projeto projeto)
    {
           //return projetoService.criar(projeto);
    }

    
    @GetMapping
    public void list()
    {
           //return projetoService.listar();
    }

    
    @GetMapping("/{id}")
    public void search(@PathVariable Long id)
    {
           //return projetoService.buscar(id);
    }

    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Projeto projeto)
    {
        //return projetoService.atualizar(id, projeto);
    } 

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        //projetoService.deletar(id);
    } 

}
