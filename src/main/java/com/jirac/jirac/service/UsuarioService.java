package com.jirac.jirac.service;

import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.exceptions.CpfInvalidoException;
import com.jirac.jirac.repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String limparCpf(String cpf) {
        if (cpf.matches("^/d{11}$")) {
            return cpf;
        }
        cpf.replace(".", "");
        cpf.replace("-", "");
        if (cpf.matches("^/d{11}$")) {
            return cpf;
        }
        throw new CpfInvalidoException("CPF inválido.");
    }

    public boolean gerarDigitos(String cpf) {
        char[] valido = cpf.toCharArray();
        int temp1 = valido[0];
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
