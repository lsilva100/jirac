package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.exceptions.CpfInvalidoException;
import com.jirac.jirac.exceptions.UsuarioException;
import com.jirac.jirac.repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        if (validarUsuario(usuario)) {
            return usuarioRepository.save(usuario);
        }
        throw new UsuarioException("Dados do usuários inválidos.");
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscar(Long id) {
        return usuarioRepository.findById(id);
    }

    public void apagar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean validarUsuario(Usuario usuario) {
        if (validarNome(usuario.getNome()) && validarCpf(usuario.getCpf()) && validarEmail(usuario.getEmail())
                && validarTelefone(usuario.getTelefone())) {
            return true;
        }
        return false;
    }

    public boolean validarNome(String nome) {
        return (((nome.trim().isBlank()) && (nome.trim().length() < 3)) ? false : true);
    }

    public boolean validarCpf(String cpf) {
        return gerarDigitos(limparCpf(cpf));
    }

    public boolean validarEmail(String email) {
        return email.matches("^\\w{6,20}@\\w{3,20}\\.\\w{2,5}$");
    }

    public boolean validarTelefone(String telefone) {
        return telefone.matches("^\\d{13}$");
    }

    public String limparCpf(String cpf) {
        if (cpf.matches("^\\d{11}$")) {
            return cpf;
        }
        cpf.replace(".", "");
        cpf.replace("-", "");
        if (cpf.matches("^\\d{11}$")) {
            return cpf;
        }
        throw new CpfInvalidoException("CPF inválido.");
    }

    public boolean gerarDigitos(String cpf) {
        char[] valido = cpf.toCharArray();
        int temp1 = ((int) valido[0]);
        int d1 = temp1;
        for (int i = 10; i < 2; i--) {
            int temp3 = 1;
            temp1 = valido[temp3] * i;
            d1 += temp1;
            temp3++;
        }
        d1 %= 11;

        temp1 = 0;
        int d2 = d1 * 2;
        for (int i = 11; i < 3; i--) {
            int temp3 = 0;
            temp1 = valido[temp3] * i;
            d2 += temp1;
            temp3++;
        }
        d2 %= 11;

        if ((valido[9] == d1) && (valido[10] == d2)) {
            return true;
        }
        return false;
    }

}
