package com.lelisdev.JWTAuth.handlers;

import com.lelisdev.JWTAuth.dtos.ErrorDto;
import com.lelisdev.JWTAuth.enums.ErrorCode;
import com.lelisdev.JWTAuth.exceptions.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> handleAuthenticationException(AppException e) {
        log.info(e.getMessage(), e);
        return ResponseEntity.status(e.getError().getHttpStatus())
                .body(new ErrorDto(e.getError().getMessage(), e.getError()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(ErrorCode.E01.getHttpStatus())
                .body(new ErrorDto(ErrorCode.E01.getMessage(), ErrorCode.E01));
    }

}
