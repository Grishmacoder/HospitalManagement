package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.entity.Appointment;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional
    public void deletePatientById(Long patientId){
        if(!patientRepository.existsById(patientId)){
            throw new EntityNotFoundException("Patient not found");
        }
        patientRepository.deleteById(patientId);

    }
}
