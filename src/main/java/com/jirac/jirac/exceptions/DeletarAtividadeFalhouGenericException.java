package com.jirac.jirac.exceptions;

public class DeletarAtividadeFalhouGenericException extends RuntimeException {

    public DeletarAtividadeFalhouGenericException() {
        super("A exclusao da atividade falhou");
    }

    public DeletarAtividadeFalhouGenericException(String message) {
        super(message);
    }

}
