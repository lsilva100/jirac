package com.jirac.jirac.exceptions;

public class DeletarProjetoFalhouGenericException extends RuntimeException {

    public DeletarProjetoFalhouGenericException() {
        super("A exclusao do projeto falhou");
    }

    public DeletarProjetoFalhouGenericException(String message) {
        super(message);
    }

}
