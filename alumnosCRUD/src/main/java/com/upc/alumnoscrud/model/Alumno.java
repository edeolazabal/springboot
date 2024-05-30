package com.upc.alumnoscrud.model;

import jakarta.persistence.*;

@Entity
@Table (name = "students")
public class Alumno {
    // Propiedades
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="firstname", nullable = false)
    private String nombre;
    @Column(name="lastname", nullable = false)
    private String apellido;

    // Constructores
    protected Alumno () {}
    public Alumno (String n, String a) {
        this.nombre = n;
        this.apellido = a;
    }
    // Getter y Setters

    public Long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
