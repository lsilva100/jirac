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

import com.jirac.jirac.dtos.UsuarioEditarDto;
import com.jirac.jirac.dtos.UsuarioLoginDto;
import com.jirac.jirac.dtos.UsuarioMostrarDto;
import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/criar")
    public UsuarioMostrarDto create(@Valid @RequestBody UsuarioLoginDto usuarioLoginDto) {
        return usuarioService.salvar(usuarioLoginDto);
    }

    @GetMapping("/listar")
    public List<Usuario> list() {
        return usuarioService.listar();
    }

    @GetMapping("/listar/{id}")
    public UsuarioMostrarDto search(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }

    @PutMapping("/editar/{id}")
    public UsuarioMostrarDto update(@PathVariable Long id, @Valid @RequestBody UsuarioEditarDto usuarioEditarDto) {
        return usuarioService.editar(id, usuarioEditarDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/apagar/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.apagar(id);
    }

}
