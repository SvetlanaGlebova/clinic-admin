package com.example.clinicadmin.service;

import com.example.clinicadmin.repository.DoctorRepository;
import com.example.clinicadmin.repository.PatientRepository;
import org.springframework.stereotype.Service;
import com.example.clinicadmin.utils.NotificationManager;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService() {
        NotificationManager.patientRepository = patientRepository;
    }
}
