package com.hyeon.demo.exception.domain;

import com.hyeon.demo.exception.CustomException;
import com.hyeon.demo.exception.ErrorCode;

public class PostException extends CustomException {
    public PostException(ErrorCode errorCode) {
        super(errorCode);
    }
}
