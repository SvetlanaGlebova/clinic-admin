package com.example.clinicadmin.controller;

import com.example.clinicadmin.entity.Specialization;
import com.example.clinicadmin.service.SpecializationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/specialization")
public class SpecializationController {
    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @PostMapping("/specialization")
    public ResponseEntity<?> addSpecialization(@RequestBody @Valid Specialization specialization) {
        return ResponseEntity.created(URI.create("http://localhost:8080/specialization/" +
                        specializationService.addSpecialization(specialization)))
                .build();
    }

    @GetMapping("/specializations/inactive")
    public List<Specialization> getInactive() {
        return specializationService.getInactiveSpecializations();

    }
}

