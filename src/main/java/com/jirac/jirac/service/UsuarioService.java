package com.jirac.jirac.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.jirac.jirac.dtos.UsuarioEditarDto;
import com.jirac.jirac.dtos.UsuarioLoginDto;
import com.jirac.jirac.dtos.UsuarioMostrarDto;
import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.exceptions.CpfInvalidoException;
import com.jirac.jirac.exceptions.EmailInvalidoException;
import com.jirac.jirac.exceptions.NomeInvalidoException;
import com.jirac.jirac.exceptions.TelefoneInvalidoException;
import com.jirac.jirac.exceptions.UsuarioException;
import com.jirac.jirac.exceptions.UsuarioNotFoundException;
import com.jirac.jirac.mappers.UsuarioMapper;
import com.jirac.jirac.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioMostrarDto salvar(UsuarioLoginDto u) {
        Usuario usuario = usuarioMapper.toEntity(u);
        if (validarUsuario(usuario)) {
            usuarioRepository.save(usuario);
            return usuarioMapper.toMostrarDto(usuario);
        }
        throw new UsuarioException("Dados de usuário inválidos.");
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public UsuarioMostrarDto buscar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
        return usuarioMapper.toMostrarDto(usuario);
    }

    public void apagar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean validarUsuario(Usuario usuario) {
        if (!validarNome(usuario.getNome()))
            throw new NomeInvalidoException("Nome inválido.");
        if (!validarCpf(usuario.getCpf()))
            throw new CpfInvalidoException("CPF inválido.");
        if (!validarEmail(usuario.getEmail()))
            throw new EmailInvalidoException("E-mail inválido.");
        if (!validarTelefone(usuario.getTelefone()))
            throw new TelefoneInvalidoException("Telefone inválido.");

        return true;
    }

    public boolean validarNome(String nome) {
        return nome.matches("[a-zA-Z]{3,}");
    }

    public boolean validarCpf(String cpf) {
        return gerarDigitos(limparCpf(cpf));
    }

    public boolean validarEmail(String email) {
        return email.matches("[A-Za-z0-9.]+@[A-Za-z0-9.]+\\.[A-Za-z]{2,4}");
    }

    public boolean validarTelefone(String telefone) {
        return telefone.matches("[0-9]{13}");
    }

    public String limparCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.matches("\\d{11}")) {
            return cpf;
        }
        throw new CpfInvalidoException("CPF inválido.");
    }

    public boolean gerarDigitos(String cpf) {
        char[] valido = cpf.toCharArray();
        int d1 = 0;
        int temp3 = 0;
        int temp1 = 0;
        for (int i = 10; i >= 2; i--) {
            temp1 = Character.getNumericValue(valido[temp3]) * i;
            d1 += temp1;
            temp3++;
        }
        temp1 = 0;
        temp3 = 0;
        int d2 = 0;
        for (int i = 11; i >= 2; i--) {
            temp1 = Character.getNumericValue(valido[temp3]) * i;
            d2 += temp1;
            temp3++;
        }

        int r1 = d1 % 11;
        int r2 = d2 % 11;

        if ((Character.getNumericValue(valido[9]) == ((r1 < 2) ? 0 : 11 - r1))
                && (Character.getNumericValue(valido[10]) == (((r2 < 2) ? 0 : 11 - r2)))) {
            return true;
        }
        return false;
    }

    public UsuarioMostrarDto editar(Long id, UsuarioEditarDto u) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
        usuarioMapper.updateUsuario(u, usuario);
        if (validarUsuario(usuario)) {
            usuarioRepository.save(usuario);
            return usuarioMapper.toMostrarDto(usuario);
        }
        throw new UsuarioException("Dados de usuário inválidos.");
    }

}
