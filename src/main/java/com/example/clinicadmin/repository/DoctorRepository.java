package com.example.clinicadmin.repository;

import com.example.clinicadmin.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(nativeQuery = true, value = "SELECT doctor.* FROM doctor " +
            "JOIN doctor_specialization  ON doctor.id = doctor_specialization.doctor_id " +
            "JOIN specialization.id" +
    "WHERE code_lat = :code")
    List<Doctor> findDoctorBySpecializationCode(String code);

    /*@Query(nativeQuery = true, value = "SELECT doctor.* FROM doctor ")
    void findActiveDoctors();*/
}
