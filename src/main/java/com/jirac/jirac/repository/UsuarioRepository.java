package com.jirac.jirac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jirac.jirac.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
