package com.jirac.jirac.exceptions;

public class CriacaoProjetoFalhouGenericException extends RuntimeException {

    public CriacaoProjetoFalhouGenericException() {
        super("Houve uma falha na criacao do projeto");
    }

    public CriacaoProjetoFalhouGenericException(String message) {
        super(message);
    }

}
