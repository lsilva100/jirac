package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class CpfJaCadastradoException extends ErrorResponseException {

    public CpfJaCadastradoException(String cpf) {
        super(HttpStatus.CONFLICT);
        setDetail("CPF " + cpf + " ja cadastrado");
    }
}
