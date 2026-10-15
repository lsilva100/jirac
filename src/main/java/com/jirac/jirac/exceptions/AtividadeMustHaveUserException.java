package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class AtividadeMustHaveUserException extends ErrorResponseException {

    public AtividadeMustHaveUserException(Long id) {
        super(HttpStatus.BAD_REQUEST);
        setDetail("O usuário de id: " + id + " não existe");
    }

}
