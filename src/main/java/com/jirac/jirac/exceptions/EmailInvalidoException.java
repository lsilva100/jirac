package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class EmailInvalidoException extends ErrorResponseException {
    public EmailInvalidoException(String email) {
        super(HttpStatus.BAD_REQUEST);
        setDetail(email);
    }
}
