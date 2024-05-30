package com.upc.alumnoapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Alumno {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstname;
    private String lastname;
    @ManyToOne()
    @JoinColumn(name ="idSchool")
    private Escuela escuela;


}
