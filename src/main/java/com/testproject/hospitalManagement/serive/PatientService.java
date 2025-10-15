package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.dto.PatientResponseDto;
import com.testproject.hospitalManagement.entity.Appointment;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {


    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public PatientResponseDto getPatientById(long id){
        Patient p =  patientRepository.findById(id).orElseThrow();
        return modelMapper.map(p,PatientResponseDto.class);
    }

    @Transactional
    public void deletePatientById(Long patientId){
        if(!patientRepository.existsById(patientId)){
            throw new EntityNotFoundException("Patient not found");
        }
        patientRepository.deleteById(patientId);

    }
    public List<PatientResponseDto> getAllPatients(Integer pageNum, Integer pageSize){
        return patientRepository.findAllPatient(PageRequest.of(pageNum,pageSize))
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
                .collect(Collectors.toList());
    }
}
