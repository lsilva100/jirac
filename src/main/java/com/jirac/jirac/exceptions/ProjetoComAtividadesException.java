package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class ProjetoComAtividadesException extends ErrorResponseException {

    public ProjetoComAtividadesException(Long id) {
        super(HttpStatus.BAD_REQUEST);
        setDetail("Existem atividades pendentes nesse projeto.");
    }
}