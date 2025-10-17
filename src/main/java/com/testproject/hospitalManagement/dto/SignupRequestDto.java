package com.testproject.hospitalManagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SignupRequestDto {
    private String username;
    private String password;
    private String name;
}
