package com.com.clientecrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Cliente {
    // Propiedades
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "firstname", nullable=false)
    private String nombre;
    @Column(name = "lasttname", nullable=false)
    private String apellido;

    // Constructores
    protected Cliente () {}
        public Cliente (String nom, String ape) {
        this.nombre = nom;
        this.apellido = ape;
    }
    // Getters
    public Long getId() {
        return Id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    // Setters
    public void setNombre(String n) {
        this.nombre = n;
    }
    public void setApellido(String a) {
        this.apellido = a;
    }

}
