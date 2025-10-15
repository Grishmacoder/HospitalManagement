package com.testproject.hospitalManagement.controller;

import com.testproject.hospitalManagement.dto.AppointmentResDto;
import com.testproject.hospitalManagement.dto.CreateAppointmentReqDto;
import com.testproject.hospitalManagement.dto.PatientResponseDto;
import com.testproject.hospitalManagement.serive.ApppointmentService;
import com.testproject.hospitalManagement.serive.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final ApppointmentService apppointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResDto> createNewApp(@RequestBody CreateAppointmentReqDto createAppointmentReqDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(apppointmentService.createNewAppointment(createAppointmentReqDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile(){
        Long patientId = 5l;
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }
}
