package com.jirac.jirac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jirac.jirac.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByTelefone(String telefone);

}
