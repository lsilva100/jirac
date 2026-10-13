package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class AtividadeMustHaveProjectException extends ErrorResponseException {

    public AtividadeMustHaveProjectException(Long id) {
        super(HttpStatus.BAD_REQUEST);
        setDetail("O projeto de id: " + id + " não existe");
    }
}