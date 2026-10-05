package com.jirac.jirac.exceptions;

public class BuscaAtividadeFalhouGenericException extends RuntimeException {

    public BuscaAtividadeFalhouGenericException() {
        super("A busca pela atividade falhou");
    }

    public BuscaAtividadeFalhouGenericException(String message) {
        super(message);
    }

}
