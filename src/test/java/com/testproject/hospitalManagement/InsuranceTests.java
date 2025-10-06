package com.testproject.hospitalManagement;

import com.testproject.hospitalManagement.entity.Insurance;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.serive.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("SunLife_1234")
                .provider("SunLife")
                .validUntil(LocalDate.of(2030,12,31))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1l);
        System.out.println(patient);
    }
}
