package com.jirac.jirac.exceptions;

public class AtualizarProjetoFalhouGenericException extends RuntimeException {

    public AtualizarProjetoFalhouGenericException() {
        super("A atualizacao do projeto falhou");
    }

    public AtualizarProjetoFalhouGenericException(String message) {
        super(message);
    }

}
