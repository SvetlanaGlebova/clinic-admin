package com.example.clinicadmin.controller;

import com.example.clinicadmin.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

public class PatientController {
    @GetMapping
    Page<Patient> patientPage(int page, int size){
        return patientPage(int page, int size);
    }
}
