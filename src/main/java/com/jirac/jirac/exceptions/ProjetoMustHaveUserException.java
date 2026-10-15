package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class ProjetoMustHaveUserException extends ErrorResponseException {

    public ProjetoMustHaveUserException(Long id) {
        super(HttpStatus.BAD_REQUEST);
        setDetail("O usuário de id: " + id + " não existe");
    }

}
