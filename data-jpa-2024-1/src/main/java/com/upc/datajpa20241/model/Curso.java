package com.upc.datajpa20241.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @ManyToMany(mappedBy = "cursos")
    List<Estudiante> estudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
    }
}
