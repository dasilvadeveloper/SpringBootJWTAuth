package com.lelisdev.JWTAuth.exceptions;

import com.lelisdev.JWTAuth.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends RuntimeException {
    private final ErrorCode error;
}
