package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Transactional
    public Patient getPatientById(long id){
        Patient p =  patientRepository.findById(id).orElseThrow();
        return p;
    }


}
