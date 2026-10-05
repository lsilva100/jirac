package com.jirac.jirac.exceptions;

public class CriacaoAtividadeFalhouGenericException extends RuntimeException {

    public CriacaoAtividadeFalhouGenericException() {
        super("Houve uma falha na criacao da atividade");
    }

    public CriacaoAtividadeFalhouGenericException(String message) {
        super(message);
    }

}
