package com.testproject.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    private Set<Doctor> doctors = new HashSet<>();
}
