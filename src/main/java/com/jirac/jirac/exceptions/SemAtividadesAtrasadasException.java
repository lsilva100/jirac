package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class SemAtividadesAtrasadasException extends ErrorResponseException {

    public SemAtividadesAtrasadasException() {
        super(HttpStatus.NOT_FOUND);
        setDetail("Não existem atividades atrasadas.");
    }
}
