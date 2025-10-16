package com.testproject.hospitalManagement.security;

import com.testproject.hospitalManagement.dto.LoginReqDto;
import com.testproject.hospitalManagement.dto.LoginResponseDto;
import com.testproject.hospitalManagement.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    public LoginResponseDto login(LoginReqDto loginReqDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        return null;
    };
}
