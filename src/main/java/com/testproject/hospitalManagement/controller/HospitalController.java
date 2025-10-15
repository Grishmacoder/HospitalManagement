package com.testproject.hospitalManagement.controller;

import com.testproject.hospitalManagement.dto.DoctoreResponseDto;
import com.testproject.hospitalManagement.serive.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class HospitalController {
        private final DoctorService doctorService;

        @GetMapping("/doctors")
        public ResponseEntity<List<DoctoreResponseDto>> getAllDoctors(){
            return ResponseEntity.ok(doctorService.getAllDoctors());
        }

}
