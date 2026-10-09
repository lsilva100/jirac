package com.jirac.jirac.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers,HttpStatusCode status,WebRequest request) {

        Throwable cause = ex.getMostSpecificCause();

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Bad Request");

        String rawMessage = cause.getLocalizedMessage();

        String[] tokens = rawMessage.split(rawMessage)


        problem.setDetail(cause.getMessage());

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    
}


