package com.jirac.jirac.exceptions;

public class BuscaProjetoFalhouGenericException extends RuntimeException {

    public BuscaProjetoFalhouGenericException() {
        super("A busca pelo projeto falhou");
    }

    public BuscaProjetoFalhouGenericException(String message) {
        super(message);
    }

}
