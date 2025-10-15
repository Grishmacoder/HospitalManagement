package com.testproject.hospitalManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentReqDto {
    private Long doctorId;
    private Long patientId;
    private LocalDateTime appointmentTime;
    private String reason;
}
