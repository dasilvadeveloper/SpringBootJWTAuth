package com.lelisdev.JWTAuth.services;

import com.lelisdev.JWTAuth.dtos.CredentialsDto;
import com.lelisdev.JWTAuth.dtos.UserLoginDto;
import com.lelisdev.JWTAuth.enums.ErrorCode;
import com.lelisdev.JWTAuth.exceptions.AppException;
import com.lelisdev.JWTAuth.mappers.UserMapper;
import com.lelisdev.JWTAuth.models.User;
import com.lelisdev.JWTAuth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public UserLoginDto login(CredentialsDto credentialsDto) {
        // GET the user by username, if it doesn't exist so thrown error and return unauthorized
        User user = userRepository.findByUsername(credentialsDto.username()).orElse(null);

        // if the user is not valid, set a DUMMY HASH to force the Bcrypt validation to make the response time equal for both invalid username/password
        String DUMMY_BCRYPT_HASH = "$2a$10$......";
        String hashToCheck = (user != null) ? user.getPassword() : DUMMY_BCRYPT_HASH;

        // validate password hash
        boolean matches = passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), hashToCheck);

        if (user == null || !matches) throw new AppException(ErrorCode.E02); // return unauthorized

        // return user login dto
        return userMapper.userToUserLoginDto(user); // return the user

    }

}
