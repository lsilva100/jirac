package com.jirac.jirac.exceptions;

public class AtualizarAtividadeFalhouGenericException extends RuntimeException {

    public AtualizarAtividadeFalhouGenericException() {
        super("A atualizacao da atividade falhou");
    }

    public AtualizarAtividadeFalhouGenericException(String message) {
        super(message);
    }

}
