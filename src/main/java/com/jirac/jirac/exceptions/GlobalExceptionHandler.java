package com.jirac.jirac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CriacaoUsuarioFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleCriacaoUsuario(CriacaoUsuarioFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

    @ExceptionHandler(BuscaUsuarioFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleBuscaUsuario(BuscaUsuarioFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())).build();
    }

    @ExceptionHandler(AtualizarUsuarioFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleAtualizarUsuario(AtualizarUsuarioFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

    @ExceptionHandler(DeletarUsuarioFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleDeletarUsuario(DeletarUsuarioFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())).build();
    }

    @ExceptionHandler(CriacaoProjetoFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleCriacaoProjeto(CriacaoProjetoFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

    @ExceptionHandler(BuscaProjetoFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleBuscaProjeto(BuscaProjetoFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())).build();
    }

    @ExceptionHandler(AtualizarProjetoFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleAtualizarProjeto(AtualizarProjetoFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

    @ExceptionHandler(DeletarProjetoFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleDeletarProjeto(DeletarProjetoFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())).build();
    }

    @ExceptionHandler(CriacaoAtividadeFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleCriacaoAtividade(CriacaoAtividadeFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

    @ExceptionHandler(BuscaAtividadeFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleBuscaAtividade(BuscaAtividadeFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())).build();
    }

    @ExceptionHandler(AtualizarAtividadeFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleAtualizarAtividade(AtualizarAtividadeFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

    @ExceptionHandler(DeletarAtividadeFalhouGenericException.class)
    public ResponseEntity<ProblemDetail> handleDeletarAtividade(DeletarAtividadeFalhouGenericException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())).build();
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<ProblemDetail> handleCpfInvalido(CpfInvalidoException ex) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage())).build();
    }

}
