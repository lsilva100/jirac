package com.jirac.jirac.exceptions;

public class DeletarUsuarioFalhouGenericException extends RuntimeException {

    public DeletarUsuarioFalhouGenericException() {
        super("A exclusao do usuario falhou");
    }

    public DeletarUsuarioFalhouGenericException(String message) {
        super(message);
    }

}
