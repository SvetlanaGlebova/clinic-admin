package com.example.clinicadmin.utils;

import com.example.clinicadmin.entity.Doctor;
import com.example.clinicadmin.entity.Patient;
import com.example.clinicadmin.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.logging.Logger;

import static jdk.internal.jrtfs.JrtFileAttributeView.AttrID.size;

@Slf4j
public class NotificationManager {

    public static PatientRepository patientRepository;

    public static void sendMessage(String message, Patient patient) {
        log("Sending message to " + patient.getemail());
    }

    public static void notifyAboutDoctor(Doctor doctor) {

        new Thread(() -> {
            Page<Patient> patientPage(long id, String email){
                Pageable pageable = PageRequest.of(page, size);
                return patientRepository;
            }

            List<Patient> patients = (List<Patient>) patientRepository.findAll();
            for (Patient patient : patients) {
                NotificationManager.sendMessage("В базу данных добавлен новый врач: " + doctor.getLastName(), patient);
            }
        }).start();
    }
}
