package com.first.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExcepton extends RuntimeException{
    public BadRequestExcepton(String msg) {
        super(msg);
    }
}
