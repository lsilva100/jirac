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

import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.exceptions.*;
import com.jirac.jirac.service.AtividadeService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/v1/atividades") 
public class AtividadeController {
    
    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService){
        this.atividadeService = atividadeService;
    }

    @ResponseStatus(HttpStatus.CREATED) 
    @PostMapping
    public void create(@Valid @RequestBody Atividade atividade)
    throws CriacaoAtividadeFalhouGenericException
    {
           //return atividadeService.criar(atividade);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public void list()
    {
           //return atividadeService.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public void search(@PathVariable Long id)
    throws BuscaAtividadeFalhouGenericException
    {
           //return atividadeService.buscar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Atividade atividade)
    throws AtualizarAtividadeFalhouGenericException
    {
        //return atividadeService.atualizar(id, atividade);
    } 

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    throws DeletarAtividadeFalhouGenericException
    {
        //atividadeService.deletar(id);
    } 

}
