package com.lelisdev.JWTAuth.controllers;

import com.lelisdev.JWTAuth.dtos.CredentialsDto;
import com.lelisdev.JWTAuth.dtos.UserLoginDto;
import com.lelisdev.JWTAuth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("api/login")
    public ResponseEntity<UserLoginDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserLoginDto userLoginDto = this.authService.login(credentialsDto);

        // TODO: create a token for the logged user

        return ResponseEntity.ok(userLoginDto);
    }

}
