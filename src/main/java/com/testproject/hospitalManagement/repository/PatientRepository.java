package com.testproject.hospitalManagement.repository;

import com.testproject.hospitalManagement.entity.Patient;
import com.testproject.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient getPatientByName(String name);

    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup ")
    List<Object[]> countEachBloodGrpType();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatient();

    @Modifying
    @Transactional
    @Query("Update Patient p SET p.name=:name where p.id=:id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
