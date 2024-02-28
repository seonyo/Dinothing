package com.example.Dinothing.exception;

import com.example.Dinothing.exception.error.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordNotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public PasswordNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
