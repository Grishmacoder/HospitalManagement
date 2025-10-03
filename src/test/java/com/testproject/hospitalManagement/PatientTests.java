package com.testproject.hospitalManagement;

import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.PatientRepository;
import com.testproject.hospitalManagement.serive.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepo(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

        List<Patient> plist = patientRepository.findAllPatient();
        System.out.println(plist);
    }

    @Autowired
    private PatientService patientService;

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientRepository.getPatientByName("Grishma Patel");
//        System.out.println(patient);

//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGrpType();
//        for(Object[] obj : bloodGroupList){
//            System.out.println(obj[0] +" "+ obj[1]);
//
//        }
        int rowsUpdated = patientRepository.updateNameWithId("Diya Patel", 3L);
        System.out.println(rowsUpdated);
    }
}
