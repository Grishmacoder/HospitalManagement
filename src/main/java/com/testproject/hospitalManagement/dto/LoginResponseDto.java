package com.testproject.hospitalManagement.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    String jwt;
    Long userId;
}
