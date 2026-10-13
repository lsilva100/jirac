package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class NomeInvalidoException extends ErrorResponseException {
    public NomeInvalidoException(String nome) {
        super(HttpStatus.BAD_REQUEST);
        setDetail(nome + "pois possui menos que 3 letras");
    }
}
