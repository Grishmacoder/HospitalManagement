package com.testproject.hospitalManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResDto {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private DoctoreResponseDto doctor;
}
