package com.testproject.hospitalManagement.entity;

import com.testproject.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Builder
@Table(
        indexes = {
                @Index(name = "idx_patient_birt_date", columnList = "birthDate")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
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


    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE},orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();
}
