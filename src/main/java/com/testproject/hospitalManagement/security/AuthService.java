package com.testproject.hospitalManagement.security;

import com.testproject.hospitalManagement.dto.LoginReqDto;
import com.testproject.hospitalManagement.dto.LoginResponseDto;
import com.testproject.hospitalManagement.dto.SignupRequestDto;
import com.testproject.hospitalManagement.dto.SignupResponseDto;
import com.testproject.hospitalManagement.entity.User;
import com.testproject.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginReqDto loginReqDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(token, user.getId());
    };

    public SignupResponseDto signup(SignupRequestDto signupReqDto) {
        User user = userRepository.findByusername(signupReqDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("user exsist");
        user = userRepository.save(User.builder()
                .username(signupReqDto.getUsername())
                .password(passwordEncoder.encode(signupReqDto.getPassword()))
                .build()
        );
        return new SignupResponseDto(user.getId(), user.getUsername());

    }
}
