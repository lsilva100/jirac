package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class SemAtividadesFinalizadasException extends ErrorResponseException {

    public SemAtividadesFinalizadasException() {
        super(HttpStatus.BAD_REQUEST);
        setDetail("Não existem atividades finalizadas.");
    }
}