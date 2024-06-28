package com.example.clinicadmin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
//user  or   group - есть в postgres, поэтому меняем на любые другие названия или таблица не создастся
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "first_name", nullable = false)
    private String firstName;


    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_active",
            columnDefinition = "BOOLEAN DEFAULT true",
            insertable = false)
    private boolean isActive;

    @Min(value = 3, message = "Опыт работы не менее 3 лет")
    @Column(name = "experience", nullable = false)
    private int experience;

    @ManyToOne // specialization_id - FK
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToMany
    @JoinTable(name = "doctor_specialization",
    joinColumns = @JoinColumn(name = "doctor_id"),
    inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private List<Specialization> specializations = new ArrayList<>();
}


