package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.entity.Insurance;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.InsuranceRepository;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with this id: "+patientId));
        patient.setInsurance(insurance);
        return patient;

    }
}
