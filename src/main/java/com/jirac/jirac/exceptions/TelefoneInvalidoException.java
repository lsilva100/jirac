package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class TelefoneInvalidoException extends ErrorResponseException {
    public TelefoneInvalidoException(String telefone) {
        super(HttpStatus.BAD_REQUEST);
        setDetail(telefone + ". O formato válido é 5548999999999");
    }
}
