package com.jirac.jirac.exceptions;

public class CriacaoUsuarioFalhouGenericException extends RuntimeException {

    public CriacaoUsuarioFalhouGenericException() {
        super("Houve uma falha na criacao do usuario");
    }

    public CriacaoUsuarioFalhouGenericException(String message) {
        super(message);
    }

}
