package com.jirac.jirac.exceptions;

public class BuscaUsuarioFalhouGenericException extends RuntimeException {

    public BuscaUsuarioFalhouGenericException() {
        super("A busca pelo usuario falhou");
    }

    public BuscaUsuarioFalhouGenericException(String message) {
        super(message);
    }

}
