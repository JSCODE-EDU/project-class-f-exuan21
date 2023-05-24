package com.hyeon.demo.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorResult {

    private HttpStatus httpStatus;
    private String message;

}
