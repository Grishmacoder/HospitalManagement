package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.entity.Insurance;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.InsuranceRepository;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with this id: "+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;

    }
    @Transactional
    public Patient disassociateInsurance(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with this id: "+patientId));
        patient.setInsurance(null);
        return  patient;
    }
}
