package com.hyeon.demo.exception.domain;

import com.hyeon.demo.exception.CustomException;
import com.hyeon.demo.exception.ErrorCode;

public class MyCustomException extends CustomException {
    public MyCustomException(ErrorCode errorCode) {
        super(errorCode);
    }
}
