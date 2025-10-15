package com.testproject.hospitalManagement;

import com.testproject.hospitalManagement.entity.Appointment;
import com.testproject.hospitalManagement.serive.ApppointmentService;
import com.testproject.hospitalManagement.serive.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
@SpringBootTest
public class AppointmentTests {

    @Autowired
    private ApppointmentService apppointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAPoointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,15,14,00))
                .reason("Eye Checkup")
                .build();
        var newApp = apppointmentService.createNewAppointment(appointment,1l,4l);
        Appointment appointment1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,20,12,25))
                .reason("Therapy")
                .build();
        apppointmentService.createNewAppointment(appointment1, 2l,5l);

        Appointment appointment2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,10,2,25))
                .reason("Throat Infection")
                .build();
        apppointmentService.createNewAppointment(appointment2, 2l,6l);




    }
}
