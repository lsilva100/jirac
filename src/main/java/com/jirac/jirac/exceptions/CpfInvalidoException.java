package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class CpfInvalidoException extends ErrorResponseException {
   
    public CpfInvalidoException(String cpfMessage) {
        super(HttpStatus.BAD_REQUEST);
        setDetail(cpfMessage);
    }
}
