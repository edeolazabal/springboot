package com.upc.relaciones.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable (name = "estudiante_curso", joinColumns = @JoinColumn(name= "estudiante_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name= "curso_id", referencedColumnName = "id"))
    List<Curso> cursos;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }
}
