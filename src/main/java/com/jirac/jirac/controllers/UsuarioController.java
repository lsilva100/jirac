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

import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.exceptions.*;
import com.jirac.jirac.service.UsuarioService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/v1/usuarios") 
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @ResponseStatus(HttpStatus.CREATED) 
    @PostMapping
    public void create(@Valid @RequestBody Usuario usuario)
    throws CriacaoUsuarioFalhouGenericException
    {
           //return usuarioService.criar(usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public void list()
    {
           //return usuarioService.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public void search(@PathVariable Long id)
    throws BuscaUsuarioFalhouGenericException
    {
           //return usuarioService.buscar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Usuario usuario)
    throws AtualizarUsuarioFalhouGenericException
    {
        //return usuarioService.atualizar(id, usuario);
    } 

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    throws DeletarUsuarioFalhouGenericException
    {
        //usuarioService.deletar(id);
    } 

}
