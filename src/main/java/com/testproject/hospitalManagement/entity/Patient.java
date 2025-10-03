package com.testproject.hospitalManagement.entity;

import com.testproject.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Entity
@Table(
        indexes = {
                @Index(name = "idx_patient_birt_date", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    private LocalDate birthDate;

    @Column(nullable = false)
    private  String email;

    private  String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
