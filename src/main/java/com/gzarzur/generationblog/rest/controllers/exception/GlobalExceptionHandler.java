package com.gzarzur.generationblog.rest.controllers.exception;

import com.gzarzur.generationblog.domain.exceptions.ObjectNotFoundException;
import com.gzarzur.generationblog.domain.exceptions.RuleViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DefaultError handlerObjectNotFoundException(ObjectNotFoundException e){
        return new DefaultError(List.of(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DefaultError handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new DefaultError(e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
    }

    @ExceptionHandler(RuleViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DefaultError handlerRuleViolationException(RuleViolationException e){
        return new DefaultError(List.of(e.getMessage()));
    }
}
