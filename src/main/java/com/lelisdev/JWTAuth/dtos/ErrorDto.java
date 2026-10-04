package com.lelisdev.JWTAuth.dtos;

import com.lelisdev.JWTAuth.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    String message;
    ErrorCode code;
}
