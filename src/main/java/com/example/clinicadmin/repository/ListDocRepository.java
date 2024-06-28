package com.example.clinicadmin.repository;

import com.example.clinicadmin.entity.Specialization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ListDocRepository extends CrudRepository<Specialization, Integer> {

    @Query(nativeQuery = true, value = "SELECT + FROM specialization WHERE is_active = false")
    List<Specialization> findByActiveFalse();
    }

