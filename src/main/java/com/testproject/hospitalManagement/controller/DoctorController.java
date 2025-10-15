package com.testproject.hospitalManagement.controller;

import com.testproject.hospitalManagement.dto.AppointmentResDto;
import com.testproject.hospitalManagement.serive.ApppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final ApppointmentService apppointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResDto>> getAllAppointmentsOfDoctor(){
        return ResponseEntity.ok(apppointmentService.getAllAppointmentOfDoctor(1l));
    }
}
