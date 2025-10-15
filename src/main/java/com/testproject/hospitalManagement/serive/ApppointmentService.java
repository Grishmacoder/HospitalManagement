package com.testproject.hospitalManagement.serive;

import com.testproject.hospitalManagement.dto.AppointmentResDto;
import com.testproject.hospitalManagement.dto.CreateAppointmentReqDto;
import com.testproject.hospitalManagement.entity.Appointment;
import com.testproject.hospitalManagement.entity.Doctor;
import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.repository.AppointmentRepository;
import com.testproject.hospitalManagement.repository.DoctorRepository;
import com.testproject.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.security.PublicKey;
import java.text.Collator;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResDto createNewAppointment(CreateAppointmentReqDto createAppointmentReqDto){
        Long doctorId = createAppointmentReqDto.getDoctorId();
        Long patientId = createAppointmentReqDto.getPatientId();

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        Appointment appointment = Appointment.builder()
                .appointmentTime(createAppointmentReqDto.getAppointmentTime())
                .reason(createAppointmentReqDto.getReason())
                .build();


        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); //bidirectional consistency

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResDto.class);
    }
//    @Transactional
//    public Appointment reassignAppointment(Long appointmentId, Long doctorId){
//        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
//        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
//
//        appointment.setDoctor(doctor);
//
//        return appointment;
//    }
    public List<AppointmentResDto> getAllAppointmentOfDoctor(Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        return doctor.getAppointments()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResDto.class))
                .collect(Collectors.toList());
    }


}
