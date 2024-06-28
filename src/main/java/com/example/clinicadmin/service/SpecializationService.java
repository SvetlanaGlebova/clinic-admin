package com.example.clinicadmin.service;

import com.example.clinicadmin.entity.Specialization;
import com.example.clinicadmin.repository.SpecializationRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecializationService {
    private final SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public int addSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization).getId();
    }

    public List<Specialization> getInactiveSpecializations() {
        List<Specialization> inactiveSpecializations =
                specializationRepository.findByIsActiveFalse();

        /*List<SpecializationDtoResponse> dtoList = new ArrayList<>();
        for(Specialization spec : inactiveSpecializations){
            dtoList.add(new SpecializationDtoResponse(spec));
        }
        return dtoList;*/

        // TODO::
        //  1. получить количество активных и неактивных докторов
        //     неактивных специализаций
        //  2. сформировать List<SpecializationDtoResponse>
        return inactiveSpecializations;
    }

    public List<Specialization> getSpecialization() {
        Specialization specialization01 = new Specialization();
        specialization01.setId(1);
        specialization01.setName("Невролог");
        specialization01.setCode("neurologist");
        Specialization specialization02 = new Specialization();
        specialization02.setId(2);
        specialization02.setName("ЛОР");
        specialization02.setCode("lor");
        List<Specialization> specializations = specializationRepository.findAll();
        if (specializations.isEmpty()) {
            specializations.add(specialization01);
            specializations.add(specialization02);
        }
        return specializations;
    }
}




