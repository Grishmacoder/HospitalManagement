package com.testproject.hospitalManagement;

import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.PatientRepository;
import com.testproject.hospitalManagement.serive.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepo(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Autowired
    private PatientService patientService;

    @Test
    public void testTransactionMethods(){
        Patient p = patientService.getPatientById(1);
        System.out.println(p);
    }
}
