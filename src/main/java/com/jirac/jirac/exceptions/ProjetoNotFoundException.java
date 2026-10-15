package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class ProjetoNotFoundException extends ErrorResponseException {

    public ProjetoNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND);
        setDetail("O projeto de id: " + id + " não existe");
    }

}
