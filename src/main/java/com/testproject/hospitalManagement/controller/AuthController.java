package com.testproject.hospitalManagement.controller;

import com.testproject.hospitalManagement.dto.LoginReqDto;
import com.testproject.hospitalManagement.dto.LoginResponseDto;
import com.testproject.hospitalManagement.dto.SignupResponseDto;
import com.testproject.hospitalManagement.dto.SignupRequestDto;
import com.testproject.hospitalManagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginReqDto loginReqDto){
        return ResponseEntity.ok(authService.login(loginReqDto));

    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));

    }

}
