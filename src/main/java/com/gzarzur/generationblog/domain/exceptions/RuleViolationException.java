package com.gzarzur.generationblog.domain.exceptions;

public class RuleViolationException extends RuntimeException {

    public RuleViolationException(String message) {
        super(message);
    }
}
