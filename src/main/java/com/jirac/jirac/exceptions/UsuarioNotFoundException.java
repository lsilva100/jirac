package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class UsuarioNotFoundException extends ErrorResponseException {

    public UsuarioNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND);
        setDetail("O usuário de id: " + id + " não existe");
    }

}
