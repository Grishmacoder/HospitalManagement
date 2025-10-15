package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.entity.Appointment;
import com.testproject.hospitalManagement.entity.Doctor;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.AppointmentRepository;
import com.testproject.hospitalManagement.repository.DoctorRepository;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
@RequiredArgsConstructor
public class ApppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment alredy exsisted");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); //bidirectional consistency


        return appointmentRepository.save(appointment);
    }
    @Transactional
    public Appointment reassignAppointment(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        return appointment;
    }


}
