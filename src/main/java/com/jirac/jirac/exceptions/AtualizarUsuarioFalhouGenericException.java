package com.jirac.jirac.exceptions;

public class AtualizarUsuarioFalhouGenericException extends RuntimeException {

    public AtualizarUsuarioFalhouGenericException() {
        super("A atualizacao do usuario falhou");
    }

    public AtualizarUsuarioFalhouGenericException(String message) {
        super(message);
    }

}
