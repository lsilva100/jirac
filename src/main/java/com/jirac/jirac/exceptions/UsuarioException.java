package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class UsuarioException extends ErrorResponseException {
    public UsuarioException(String message) {
        super(HttpStatus.BAD_REQUEST);
        setDetail(message);
    }
}

