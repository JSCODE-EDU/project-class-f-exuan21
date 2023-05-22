package com.hyeon.demo.exception;

import com.hyeon.demo.exception.domain.MyCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    ResponseEntity<ErrorResult> handlePostException(CustomException e) {
        log.error("[CustomPostException] : {}, {}", e.getHttpStatus(), e.getMessage());
        ErrorResult errorResult = new ErrorResult(e.getHttpStatus(), e.getMessage());
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(errorResult);
    }

}
