package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class ProjetoComAtividadesException extends ErrorResponseException {

    public ProjetoComAtividadesException(Long id) {
        super(HttpStatus.FORBIDDEN);
        setDetail("Existem atividades pendentes nesse projeto.");
    }
}