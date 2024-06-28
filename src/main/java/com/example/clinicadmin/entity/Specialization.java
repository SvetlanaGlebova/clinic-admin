package com.example.clinicadmin.entity;

import aj.org.objectweb.asm.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Setter
//@Getter
//@Builder
@Data
@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //name VARCHAR(255) NOT NULL
    @JsonProperty("specialization_name")
    @Column(name = "name", nullable = false)
    private String name;

    //code_lat VARCHAR(255) NOT NULL
    @JsonProperty("specialization_code")
    @Column(name = "code_lat", nullable = false, unique = true)
    private String code;

    //description VARCHAR(255)
    @Column(name = "description", length = 3000)
    private String description;

    // @JdbcTypeCode
    // @Column(name = "lables", columnDefinition = "jsonb")
    // private String lebel;
    //
    // @JdbcTypeCode(Type.ARRAY)
    // @Column(name = "lebels", columnDefinition = "text[]")
    // private List<String> labels; //массив строк на уровне БД

    @Column(name = "is_active",
            columnDefinition = "BOOLEAN DEFAULT true",
            insertable = false) //updateble = false
    private boolean isActive;

    @Column(name = "created_at",
            columnDefinition = "TIMESTAMP",
            updatable = false)
    private LocalDateTime createdAt;

    //specializationRepository.save(new Specialization("ЛОР", "lor", "....", "true")

    //INSERT INTO specialization (name, code_lat, description, create
    //VALUES ('ЛОР', 'lor', '.....',

    @ManyToMany
    private List<Doctor> doctors = new ArrayList<>();


}
