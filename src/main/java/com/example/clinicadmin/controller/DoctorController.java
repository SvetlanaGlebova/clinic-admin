package com.example.clinicadmin.controller;

import com.example.clinicadmin.entity.Doctor;
import com.example.clinicadmin.entity.Specialization;
import com.example.clinicadmin.service.DoctorService;
import com.example.clinicadmin.service.SpecializationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
public class DoctorController {
    private final DoctorService doctorService;
    private final SpecializationService specializationService;

    public DoctorController(DoctorService doctorService, SpecializationService specializationService) {
        this.doctorService = doctorService;
        this.specializationService = specializationService;
    }


    @GetMapping("/doctors")
    public String getDoctors(Model model) {
        List<Doctor> doctors = doctorService.getDoctors();
        model.addAttribute("doctor_list", doctors);
        List<Specialization> specializations = specializationService
                .getSpecialization();
        model.addAttribute("specialization_list", specializations);
        return "doctor/doctors";
    }

    /*@GetMapping("/doctor/{id}")
    public String getDoctorById(@PathVariable int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor_info", doctor);
        // doctor_info - ссылка на doctor из html
        return "doctor/doctor";
    }*/

    // метод вернет форму
    @GetMapping("/doctor/form")
    public String getDoctorAddForm(Doctor doctor) {
        return "doctor/doctor-add-form";
    }

    // обработка данных из формы
    @PostMapping("/doctor")
    public String addDoctor(@Valid Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "doctor-add-form";
        doctorService.addDoctor(doctor);
        // добавление информации о докторе
        return "redirect:/doctor/form";
    }

    @GetMapping("/doctor/specialization/{code}")
    public String getDoctorBySpecializationCode(@PathVariable String code, Model model) {

        return code;

    }

    @GetMapping("/active_doctors")
    public String getActiveDoctors() {
        return doctorService.getActiveDoctors();
    }

    @GetMapping("/inactive_doctors")
    public String getInactiveDoctors() {
        return doctorService.getInactiveDoctors();
    }

}


