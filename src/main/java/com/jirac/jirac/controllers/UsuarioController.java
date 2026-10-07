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
    @PostMapping
    public Usuario create(@Valid @RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> list() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> search(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.salvar(usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.apagar(id);
    }

}
