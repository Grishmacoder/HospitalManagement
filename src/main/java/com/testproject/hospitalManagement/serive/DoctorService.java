package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.dto.DoctoreResponseDto;
import com.testproject.hospitalManagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctoreResponseDto> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctoreResponseDto.class))
                .collect(Collectors.toList());
    }
}
