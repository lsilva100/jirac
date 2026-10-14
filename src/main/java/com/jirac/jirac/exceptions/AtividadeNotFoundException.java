package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class AtividadeNotFoundException extends ErrorResponseException {

    public AtividadeNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND);
        setDetail("A atividade de id: " + id + " não existe");
    }
    
}
