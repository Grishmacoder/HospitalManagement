package com.testproject.hospitalManagement;

import com.testproject.hospitalManagement.dto.BloodGroupCntResponseEntity;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.PatientRepository;
import com.testproject.hospitalManagement.serive.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepo(){
        Page<Patient> patientList = patientRepository.findAll(PageRequest.of(0,2));
        patientList.getContent().forEach(System.out::println);

//        List<Patient> plist = patientRepository.findAllPatient();
//        for(Patient p : plist){
//            System.out.println(p);
//        }

    }

    @Autowired
    private PatientService patientService;

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientRepository.getPatientByName("Grishma Patel");
//        System.out.println(patient);


        List<BloodGroupCntResponseEntity> bloodGroupList = patientRepository.countEachBloodGrpType();
        for(BloodGroupCntResponseEntity res: bloodGroupList){
            System.out.println(res);
        }

//        int rowsUpdated = patientRepository.updateNameWithId("Diya Patel", 3L);
//        System.out.println(rowsUpdated);
    }
}
